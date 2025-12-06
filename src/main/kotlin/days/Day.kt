package ru.akaneiro.days

abstract class Day {
    open val fileName = "${this::class.java.simpleName}.txt"
}