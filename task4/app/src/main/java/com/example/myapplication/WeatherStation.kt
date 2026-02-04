package com.example.myapplication

import androidx.collection.objectListOf

class WeatherStation: Subject {
    private var currentData: WeatherData? = null

    private var currentObservers = mutableListOf<Observer>()

    // This method is called whenever new weather data is available.
    fun measurementsChanged(newData: WeatherData) {
        this.currentData = newData
        println("WeatherStation: Got new data -> $currentData")
        for (observer in currentObservers) {
            notifyObservers(observer, newData)
        }
    }

    override fun registerObserver(observer: Observer) {
        if (observer in currentObservers) {
            println("Error")
        } else {
            currentObservers.add(observer)
        }
    }

    override fun removeObserver(observer: Observer) {
        if (observer !in currentObservers){
            println("Error")
        } else {
            currentObservers.remove(observer)
        }
    }

    override fun notifyObservers(observer: Observer, weatherData: WeatherData) {
        observer.update(weatherData)
    }
}
