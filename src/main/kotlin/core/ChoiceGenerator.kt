package org.example.core

import org.example.enums.Choice
import kotlin.random.Random

class ChoiceGenerator {

    fun generateChoice(): Choice {
        return when (Random.nextInt(0, 3)) {
            0 -> Choice.ROCK
            1 -> Choice.PAPER
            2 -> Choice.SCISSORS
            else -> throw IllegalStateException("Unexpected value")
        }
    }
}