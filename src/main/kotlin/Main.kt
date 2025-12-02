package ru.akaneiro

import ru.akaneiro.days.Day02

fun main() {
    val day = Day02()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}