package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day04Test {

    val input: String = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
        """.trimIndent()

    lateinit var day: Day04

    @BeforeEach
    fun setup() {
        day = Day04()
    }

    @Test
    fun testPart1() {
        assertEquals(13, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(43, day.solvePart2(input))
    }
}