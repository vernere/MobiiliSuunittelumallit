package com.example.myapplication

class CurrentConditionsDisplay: Observer {
    fun display(weatherData: WeatherData) {
        println(" CurrentConditionsDisplay: Current conditions: ${weatherData.temperature}C degrees and ${weatherData.humidity}%\n" +
                "humidity")

    }

    override fun update(weatherData: WeatherData) {
        display(weatherData)
    }
}
