package ru.akaneiro.days

class Day02 : Day() {

    fun solvePart1(input: String): Long {
        return parseIds(input)
            .filter { id ->
                val idLength = id.length
                idLength % 2 == 0 && id.take(idLength / 2) == id.drop(idLength / 2)
            }
            .sumOf { it.toLong() }
    }

    fun solvePart2(input: String): Long {
        return parseIds(input)
            .filter { id ->
                (1..id.length / 2).any { partLength ->
                    val chunks = id.chunked(partLength)
                    chunks.all { it == chunks.first() }
                }
            }
            .sumOf { it.toLong() }
    }

    private fun parseIds(input: String): List<String> {
        return input.split(",")
            .map { ids ->
                val (start, end) = ids.split("-")
                start.toLong()..end.toLong()
            }
            .flatMap { range -> range.map { it.toString() } }
    }
}