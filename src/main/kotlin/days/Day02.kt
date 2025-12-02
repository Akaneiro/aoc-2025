package ru.akaneiro.days

class Day02 : Day() {

    fun solvePart1(input: String): Long {
        return createIdsList(input)
            .filter { isInvalidId(it) }
            .sumOf { it.toLong() }
    }

    fun solvePart2(input: String): Long {
        return createIdsList(input)
            .filter { isInValidIdPart2(it) }
            .sumOf { it.toLong() }
    }

    private fun createIdsList(input: String): List<String> {
        return splitIds(input)
            .map { (it.first..it.second).toList() }
            .flatten()
            .map { it.toString() }
    }

    private fun splitIds(input: String): List<Pair<Long, Long>> {
        return input.split(",")
            .map { ids ->
                Pair(
                    ids.substringBefore("-").toLong(),
                    ids.substringAfter("-").toLong()
                )
            }
    }

    private fun isInvalidId(num: String): Boolean {
        val length = num.length

        if (length % 2 != 0) {
            return false
        }

        val halfLength = length / 2
        val firstHalf = num.take(halfLength)
        val secondHalf = num.takeLast(halfLength)

        return firstHalf == secondHalf
    }

    private fun isInValidIdPart2(num: String): Boolean {
        val length = num.length

        if (length < 2) {
            return false
        }

        for (partLength in 1..length / 2) {
            if (length % partLength != 0) {
                continue
            }

            val repeatCount = length / partLength
            if (repeatCount < 2) {
                continue
            }

            val part = num.take(partLength)
            var valid = true

            for (i in 1 until repeatCount) {
                val currentPart = num.substring(i * partLength, (i + 1) * partLength)
                if (currentPart != part) {
                    valid = false
                    break
                }
            }

            if (valid) {
                return true
            }
        }

        return false
    }
}