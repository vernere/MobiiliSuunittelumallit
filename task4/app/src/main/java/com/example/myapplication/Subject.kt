package com.example.myapplication

interface Subject {

    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers(observer: Observer, weatherData: WeatherData)
}