package org.example.model

import org.example.enums.Choice
import org.example.enums.GameResult

class GameRound(private val player1Choice: Choice, private val player2Choice: Choice) {

    fun getResult(): GameResult {
        return when {
            (player1Choice == player2Choice) -> GameResult.TIE
            (player1Choice == Choice.PAPER && player2Choice == Choice.ROCK
                    || player1Choice == Choice.ROCK && player2Choice == Choice.SCISSORS
                    || player1Choice == Choice.SCISSORS && player2Choice == Choice.PAPER) -> GameResult.WIN

            else -> GameResult.LOSE
        }
    }
}
