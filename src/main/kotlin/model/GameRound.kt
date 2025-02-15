package org.example.model

import org.example.enums.Choice
import org.example.enums.GameResult

class GameRound(private val player1Choice: Choice, private val player2Choice: Choice) {

    fun getResult(): GameResult {
        return when {
            player1Choice == player2Choice -> GameResult.TIE
            player1Choice.beats(player2Choice) -> GameResult.WIN
            else -> GameResult.LOSE
        }
    }
}
