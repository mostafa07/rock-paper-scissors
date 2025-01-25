package org.example.model

import org.example.enums.GameResult

data class GameStats(private val gameResults: List<GameResult>) {

    fun getNumWins(): Int = gameResults.count { it == GameResult.WIN }

    fun getNumLosses(): Int = gameResults.count { it == GameResult.LOSE }

    fun getNumTies(): Int = gameResults.count { it == GameResult.TIE }
}
