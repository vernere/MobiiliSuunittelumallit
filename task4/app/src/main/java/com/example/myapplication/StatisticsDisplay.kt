package com.example.myapplication

class StatisticsDisplay: Observer {
    private val temperatures = mutableListOf<Float>()
    fun display() {
        val avgTemp = temperatures.average()
        println("StatisticsDisplay: Avg temperature: ${avgTemp}\n")
    }

    override fun update(weatherData: WeatherData) {
        temperatures.add(weatherData.temperature)
        display()
    }
}

// --- Main function to run the simulation ---
fun main() {
// 1. Create the WeatherStation (the subject).
    val weatherStation = WeatherStation()
// 2. Create the display devices (the observers).
    val currentDisplay = CurrentConditionsDisplay()
    val statsDisplay = StatisticsDisplay()
// 3. TODO: Register the observers with the weather station.
    weatherStation.registerObserver(currentDisplay)
    weatherStation.registerObserver(statsDisplay)
// Simulate new weather measurements.
    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(
        WeatherData(
            25.0f, 65f,
            1012f
        )
    )
    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(
        WeatherData(
            27.5f, 70f,
            1011f
        )
    )
// 4. TODO: Unregister one of the observers.
    println("--- Unregistering Statistics Display —\n")
    weatherStation.removeObserver(statsDisplay)
    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(
        WeatherData(
            26.0f, 90f,
            1013f
        )
    )
}