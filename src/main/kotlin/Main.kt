package ru.akaneiro

import ru.akaneiro.days.Day04

fun main() {
    val day = Day04()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}