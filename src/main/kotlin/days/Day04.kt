package ru.akaneiro.days

class Day04 : Day() {

    fun solvePart1(input: String): Int {
        val allPapers = parseInput(input)

        return allPapers
            .filter { isAccessiblePaper(it, allPapers) }
            .distinct()
            .count()
    }

    fun solvePart2(input: String): Int {
        val allPapers = parseInput(input).toMutableSet()

        return generateSequence {
            allPapers
                .filter { isAccessiblePaper(it, allPapers) }
                .takeIf { it.isNotEmpty() }
        }
            .map { accessiblePapers ->
                allPapers.removeAll(accessiblePapers.toSet())
                accessiblePapers.size
            }.sum()
    }

    private fun parseInput(input: String): List<PaperPosition> {
        return input.lines()
            .flatMapIndexed { y, line ->
                line.chunked(1).mapIndexedNotNull { x, item ->
                    item.takeIf { it == "@" }?.let { PaperPosition(x, y) }
                }
            }
    }

    private fun isAccessiblePaper(
        position: PaperPosition,
        allPapers: Collection<PaperPosition>
    ): Boolean = position.adjacent().count { it in allPapers } < 4

    private data class PaperPosition(
        val x: Int,
        val y: Int
    ) {
        fun adjacent(): List<PaperPosition> {
            return listOf(
                PaperPosition(x + 1, y), // E
                PaperPosition(x - 1, y), // W
                PaperPosition(x, y + 1), // S
                PaperPosition(x, y - 1), // N,
                PaperPosition(x + 1, y + 1), // SE
                PaperPosition(x - 1, y + 1), // SW
                PaperPosition(x + 1, y - 1), // NE
                PaperPosition(x - 1, y - 1) // NW
            )
        }
    }
}