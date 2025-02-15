package org.example.enums

enum class Choice {

    ROCK,
    PAPER,
    SCISSORS,
    SPOCK,
    LIZARD;

    fun beats(other: Choice): Boolean {
        return when (this) {
            ROCK -> other == SCISSORS || other == LIZARD
            PAPER -> other == ROCK || other == SPOCK
            SCISSORS -> other == PAPER || other == LIZARD
            LIZARD -> other == PAPER || other == SPOCK
            SPOCK -> other == SCISSORS || other == ROCK
        }
    }
}