package ru.akaneiro

import ru.akaneiro.days.Day06

fun main() {
    val day = Day06()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}