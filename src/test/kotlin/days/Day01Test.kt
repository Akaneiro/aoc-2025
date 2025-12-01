package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day01Test {
    val input: String = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
        """.trimIndent()

    lateinit var day: Day01

    @BeforeEach
    fun setup() {
        day = Day01()
    }

    @Test
    fun testPart1() {
        assertEquals(3, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(6, day.solvePart2(input))
    }

    @Test
    fun test1000() {
        assertEquals(10, day.solvePart2("R1000"))
    }
}