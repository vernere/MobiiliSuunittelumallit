package com.example.myapplication

import kotlin.math.abs

class Fraction(val numerator: Int, val denominator: Int, private val sign: Int = 1): Comparable<Fraction> {

    override fun compareTo(other: Fraction): Int {
        val left = this.numerator * other.denominator
        val right = other.numerator * this.denominator

        return when {
            left < right -> -1
            left > right -> 1
            else -> 0
        }
    }

    fun add(fraction: Fraction): Fraction {
        val newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator
        val newDenominator = this.denominator * fraction.denominator
        return simplifyFraction(newNumerator, newDenominator)
    }

    fun subtr(fraction: Fraction): Fraction{
        val newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator
        val newDenominator = this.denominator * fraction.denominator
        return Fraction(newNumerator, newDenominator)
    }

    fun mult(fraction: Fraction): Fraction{
        val newNumerator = this.numerator * fraction.numerator
        val newDenominator = this.denominator * fraction.denominator
        return Fraction(newNumerator, newDenominator)
    }

    fun div(fraction: Fraction): Fraction{
        val newNumerator = this.numerator * fraction.denominator
        val newDenominator = this.denominator * fraction.numerator
        return Fraction(newNumerator, newDenominator)
    }

    fun negate(): Fraction {
        return Fraction(this.numerator, this.denominator, this.sign * -1)
    }

    operator fun plus(fraction: Fraction): Fraction {
        val newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator
        val newDenominator = this.denominator * fraction.denominator
        return simplifyFraction(newNumerator, newDenominator)
    }

    operator fun minus(fraction: Fraction): Fraction {
        val newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator
        val newDenominator = this.denominator * fraction.denominator
        return simplifyFraction(newNumerator, newDenominator)
    }

    override fun toString(): String {
        val gcdValue = gcd(this.numerator, this.denominator)
        val simNumerator = this.numerator / gcdValue
        val simDenominator = this.denominator / gcdValue
        val effectiveSign = if (sign == -1) "-" else ""

        return "$effectiveSign${abs(simNumerator)}/${abs(simDenominator)}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if(other !is Fraction) return false

        val thisGcd = gcd(this.numerator, this.denominator)
        val otherGcd = gcd(other.numerator, other.denominator)

        val thisSimpleNum = this.numerator / thisGcd * this.sign
        val thisSimpleDen = this.denominator / thisGcd

        val otherSimpleNum = other.numerator / otherGcd * other.sign
        val otherSimpleDen = other.denominator / otherGcd

        return thisSimpleNum == otherSimpleNum && thisSimpleDen == otherSimpleDen
    }

    override fun hashCode(): Int {
        val gcdValue = gcd(abs(numerator), abs(denominator))
        val simpleNum = numerator / gcdValue * sign
        val simpleDen = denominator / gcdValue
        return 31 *simpleNum + simpleDen
    }
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    private fun simplifyFraction(numerator: Int, denominator: Int): Fraction {
        val gcdValue = gcd(numerator, denominator)
        return Fraction(numerator / gcdValue, denominator / gcdValue)
    }

}