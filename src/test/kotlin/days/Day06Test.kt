package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day06Test {

    val input: String = """
        123 328  51 64 
         45 64  387 23 
          6 98  215 314
        *   +   *   +  
        """.trimIndent()

    lateinit var day: Day06

    @BeforeEach
    fun setup() {
        day = Day06()
    }

    @Test
    fun testPart1() {
        assertEquals(4277556L, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(3263827, day.solvePart2(input))
    }
}