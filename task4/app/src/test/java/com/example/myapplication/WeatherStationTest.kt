package com.example.myapplication

import org.junit.Test // Important: Make sure this import is added

/**
 * A test class to run and verify the Observer pattern implementation.
 */
class WeatherStationTest {

    @Test    fun runWeatherSimulation() {
        // --- The logic from your main function is now here ---

        // 1. Create the WeatherStation (the subject).
        val weatherStation = WeatherStation()

        // 2. Create the display devices (the observers).
        val currentDisplay = CurrentConditionsDisplay()
        val statsDisplay = StatisticsDisplay()

        // 3. Register the observers with the weather station.
        weatherStation.registerObserver(currentDisplay)
        weatherStation.registerObserver(statsDisplay)

        // Simulate new weather measurements.
        println("--- Simulating new measurement ---")
        weatherStation.measurementsChanged(
            WeatherData(25.0f, 65f, 1012f)
        )

        println("\n--- Simulating another measurement ---")
        weatherStation.measurementsChanged(
            WeatherData(27.5f, 70f, 1011f)
        )

        // 4. Unregister one of the observers.
        println("--- Unregistering Statistics Display —\n")
        weatherStation.removeObserver(statsDisplay)

        println("\n--- Simulating a final measurement ---")
        weatherStation.measurementsChanged(
            WeatherData(26.0f, 90f, 1013f)
        )
    }
}