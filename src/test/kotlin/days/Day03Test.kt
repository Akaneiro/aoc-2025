package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03Test {
    val input: String = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
        """.trimIndent()

    lateinit var day: Day03

    @BeforeEach
    fun setup() {
        day = Day03()
    }

    @Test
    fun testPart1() {
        assertEquals(357, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(3121910778619, day.solvePart2(input))
    }
}