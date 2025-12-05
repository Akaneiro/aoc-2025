package ru.akaneiro

import ru.akaneiro.days.Day05

fun main() {
    val day = Day05()
    val input = readResourceFile(day.fileName)
    day.solvePart1(input).println()
    day.solvePart2(input).println()
}