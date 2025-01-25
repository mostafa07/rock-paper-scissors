package org.example

import core.GameController
import org.example.core.ChoiceGenerator
import org.example.enums.Choice
import org.example.model.GameStats

fun main() {
    val gameController = GameController(ChoiceGenerator())
    val gameResults = gameController.playCustomGames(100, Choice.ROCK)
    val gameStats = GameStats(gameResults)

    println("Player A wins ${gameStats.getNumWins()} of 100 games")
    println("Player B wins ${gameStats.getNumLosses()} of 100 games")
    println("Draws: ${gameStats.getNumTies()} of 100 games")
}