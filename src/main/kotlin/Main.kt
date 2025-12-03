package ru.akaneiro

import ru.akaneiro.days.Day03

fun main() {
    val day = Day03()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}