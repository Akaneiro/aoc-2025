package ru.akaneiro.days

import kotlin.math.absoluteValue

class Day01 : Day() {

    companion object {
        const val SAFE_MAX_VALUE = 99
        const val SAFE_MIN_VALUE = 0
        const val SAFE_START_POSITION = 50
        const val SAFE_SIZE = SAFE_MAX_VALUE + 1
    }

    fun solvePart1(input: String): Int {
        val rotations = createRotationsFromInput(input)
        var currentPosition = SAFE_START_POSITION
        var zerosCount = 0

        rotations.forEach { rotation ->
            val newPosition = calculateNewPosition(currentPosition, rotation)
            if (newPosition == 0) {
                zerosCount++
            }
            currentPosition = newPosition
        }
        return zerosCount
    }

    fun solvePart2(input: String): Int {
        val rotations = createRotationsFromInput(input)
        var currentPosition = SAFE_START_POSITION
        var zerosCount = 0

        rotations.forEach { rotation ->
            val oldPosition = currentPosition
            val newPosition = calculateNewPosition(currentPosition, rotation)

            // полные обороты
            val fullRotations = rotation.absoluteValue / SAFE_SIZE
            // часть от изначальных оборотов за вычетом полных оборотов
            val effectiveRotation = rotation % SAFE_SIZE

            zerosCount += fullRotations

            when {
                effectiveRotation < 0 -> {
                    if (crossesZeroMovingLeft(oldPosition, effectiveRotation)) {
                        zerosCount++
                    }
                }

                effectiveRotation > 0 -> {
                    if (crossesZeroMovingRight(oldPosition, effectiveRotation)) {
                        zerosCount++
                    }
                }
            }

            currentPosition = newPosition
        }
        return zerosCount
    }

    private fun crossesZeroMovingLeft(currentPosition: Int, rotation: Int): Boolean {
        return currentPosition + rotation <= SAFE_MIN_VALUE && currentPosition != SAFE_MIN_VALUE
    }

    private fun crossesZeroMovingRight(oldPosition: Int, rotation: Int): Boolean {
        return oldPosition + rotation >= SAFE_MAX_VALUE && oldPosition != (SAFE_MAX_VALUE - 1)
    }

    private fun calculateNewPosition(currentPosition: Int, rotation: Int): Int {
        return (currentPosition + rotation).mod(SAFE_SIZE).absoluteValue
    }

    private fun createRotationsFromInput(input: String): List<Int> {
        return input.lines().map { parseRotation(it) }
    }

    private fun parseRotation(line: String): Int {
        val direction = line.take(1)
        val value = line.substring(1, line.length)

        return when (direction) {
            "R" -> value.toInt()
            "L" -> -value.toInt()
            else -> throw IllegalArgumentException("Unknown direction: $direction")
        }
    }
}