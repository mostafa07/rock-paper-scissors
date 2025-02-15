package org.example.core

import org.example.enums.Choice
import kotlin.random.Random

class ChoiceGenerator {

    fun generateChoice(): Choice {
        return when (Random.nextInt(0, 5)) {
            0 -> Choice.ROCK
            1 -> Choice.PAPER
            2 -> Choice.SCISSORS
            3 -> Choice.LIZARD
            4 -> Choice.SPOCK
            else -> throw IllegalStateException("Unexpected value")
        }
    }
}