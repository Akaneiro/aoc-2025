package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day05Test {

    val input: String = """
        3-5
        10-14
        16-20
        12-18
        
        1
        5
        8
        11
        17
        32
        """.trimIndent()

    lateinit var day: Day05

    @BeforeEach
    fun setup() {
        day = Day05()
    }

    @Test
    fun testPart1() {
        assertEquals(3, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(14, day.solvePart2(input))
    }
}