package ru.akaneiro.days

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {
    val input: String = """
        11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
        """.trimIndent()

    lateinit var day: Day02

    @BeforeEach
    fun setup() {
        day = Day02()
    }

    @Test
    fun testPart1() {
        assertEquals(1227775554, day.solvePart1(input))
    }

    @Test
    fun testPart2() {
        assertEquals(4174379265, day.solvePart2(input))
    }
}