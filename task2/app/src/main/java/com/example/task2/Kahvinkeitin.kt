package com.example.task2



fun main() {
    val k = Kahvinkeitin()
    println(k)
    k.taytaVesiSailio()
    k.taytaKahviSailio()
    println(k)
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    println("tee espresso: ${k.teeEspresso()}")
    println(k)
    k.painaOnOffNappia()
    println("tee tavallinen kahvi: ${k.teeTavallinenKahvi()}")
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    k.taytaVesiSailio()
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
}
class Kahvinkeitin(
    var vetta: Int = 0,
    var kahvia: Int = 0,
    var power: Boolean = false,
    var maxKahvi: Int = 100,
    var maxVesi: Int = 300,

    ){
    val espressoja: Int
        get() = minOf(vetta / 30, kahvia / 16)

    val tavallisia: Int
        get() = minOf(vetta / 200, kahvia / 15)

    fun taytaVesiSailio(){
        vetta = maxVesi
    }

    fun taytaKahviSailio(){
        kahvia = maxKahvi
    }

    fun teeEspresso(): Boolean{
        if (!power) {return false}
        if (vetta < 30 || kahvia < 16 ) {
            return false
        } else {
            vetta -= 30
            kahvia -= 16
            return true
        }
    }

    fun teeTavallinenKahvi(): Boolean{
        if (!power) {return false}
        if (vetta < 200 || kahvia < 15 ) {
            return false
        } else {
            vetta -= 200
            kahvia -= 15
            return true
        }
    }

    fun painaOnOffNappia(){
        if (power) {power = false} else {power = true}
    }

    override fun toString(): String {
        return "Keitin: ${vetta}/${maxVesi} vettä, ${kahvia}/${maxKahvi} kahvia on ${if (power) "päällä" else "kiinni"}"
    }
}