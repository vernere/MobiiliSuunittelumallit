package com.example.myapplication

open class Human(val name: String, var age: Int) {
    fun getOlder(){ age += 1 }
}