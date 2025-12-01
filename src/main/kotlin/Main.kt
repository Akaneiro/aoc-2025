package ru.akaneiro

import ru.akaneiro.days.Day01

fun main() {
    val day = Day01()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}