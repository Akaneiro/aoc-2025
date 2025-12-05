package ru.akaneiro.days

import kotlin.math.max

class Day05 : Day() {

    fun solvePart1(input: String): Int {
        val (ranges, ingredients) = parseInput(input)

        return ingredients.count { ingredient ->
            ranges.any { ingredient in it }
        }
    }

    fun solvePart2(input: String): Long {
        val (ranges, _) = parseInput(input)

        return ranges
            .mergeOverlapping()
            .sumOf { it.last - it.first + 1 }
    }

    fun List<LongRange>.mergeOverlapping(): List<LongRange> {
        return sortedBy { it.first }
            .fold(mutableListOf()) { merged, current ->
                when {
                    merged.isEmpty() -> merged.apply { add(current) }
                    merged.last().last >= current.first - 1 -> merged.apply {
                        val last = removeLast()
                        add(LongRange(last.first, max(last.last, current.last)))
                    }

                    else -> merged.apply { add(current) }
                }
            }
    }

    private fun parseInput(input: String): Pair<List<LongRange>, List<Long>> {
        val lines = input.lines()
        val emptyLineIndex = lines.indexOfFirst { it.isBlank() }

        val ranges = lines
            .take(emptyLineIndex)
            .map {
                val intervals = it.split("-")
                LongRange(intervals.first().toLong(), intervals.last().toLong())
            }

        val ingredients = lines
            .drop(emptyLineIndex + 1)
            .map { it.toLong() }

        return ranges to ingredients
    }
}