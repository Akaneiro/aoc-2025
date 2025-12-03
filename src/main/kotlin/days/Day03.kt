package ru.akaneiro.days

class Day03 : Day() {

    fun solvePart1(input: String): Int {
        return parseInput(input).sumOf { getMaxJoltageFromBank(it, 2).toInt() }
    }

    fun solvePart2(input: String): Long {
        return parseInput(input).sumOf { getMaxJoltageFromBank(it, 12).toLong() }
    }

    private fun parseInput(input: String): List<String> {
        return input.split("\n")
    }

    private fun getMaxJoltageFromBank(bank: String, digitsToTake: Int): String {
        val n = bank.length

        if (n <= digitsToTake) {
            return bank
        }

        var digitsToRemove = n - digitsToTake

        val result = bank.fold(StringBuilder()) { stack, digit ->
            while (digitsToRemove > 0 && stack.isNotEmpty() && stack.last() < digit) {
                stack.deleteCharAt(stack.length - 1)
                digitsToRemove--
            }
            stack.append(digit)
        }

        repeat(digitsToRemove) {
            result.deleteCharAt(result.length - 1)
        }

        return result.toString()
    }
}