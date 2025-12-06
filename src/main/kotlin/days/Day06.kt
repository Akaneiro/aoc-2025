package ru.akaneiro.days

import kotlin.text.trim

class Day06 : Day() {

    fun solvePart1(input: String): Long {
        return solve(
            input = input,
            numbersParser = { numbersLines -> numbersLines.map { it.trim().toLong() } }
        )
    }

    fun solvePart2(input: String): Long {
        return solve(
            input = input,
            numbersParser = { numbersLines ->
                numbersLines.first().indices
                    .reversed()
                    .map { columnIndex ->
                        numbersLines.joinToString("") { line ->
                            line[columnIndex].toString()
                        }.trim().toLong()
                    }
            }
        )
    }

    private fun solve(
        input: String,
        numbersParser: (numbersLines: List<String>) -> List<Long>
    ): Long = parseInput(input)
        .map { (numbersLines, operator) ->
            Task(
                numbers = numbersParser(numbersLines),
                operator = operator
            )
        }
        .sumOf { it.solve() }

    private fun parseInput(input: String): List<Pair<List<String>, String>> {
        val lines = input.lines()
        val inputHeight = lines.size

        return lines.first().indices
            .fold(listOf(buildEmptyColumn(inputHeight))) { tasks, columnIndex ->
                val isColumnEmpty = lines.all { it[columnIndex].isWhitespace() }

                if (isColumnEmpty) {
                    tasks + listOf(buildEmptyColumn(inputHeight))
                } else {
                    tasks.dropLast(1) + listOf(
                        tasks.last().mapIndexed { i, str ->
                            str + lines[i][columnIndex]
                        }
                    )
                }
            }
            .map { column ->
                column.dropLast(1) to column.last().trim()
            }
    }

    private fun buildEmptyColumn(inputHeight: Int) = List(inputHeight) { "" }

    private data class Task(
        val numbers: List<Long>,
        val operator: String
    ) {
        fun solve(): Long {
            val (firstNumber, remainingNumbers) = numbers.first() to numbers.drop(1)

            return remainingNumbers.fold(firstNumber) { acc, num ->
                when (operator) {
                    "+" -> acc + num
                    "*" -> acc * num
                    else -> throw IllegalArgumentException("Unknown operation: $operator")
                }
            }
        }
    }
}