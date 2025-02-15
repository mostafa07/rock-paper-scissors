package core

import org.example.core.ChoiceGenerator
import org.example.enums.Choice
import org.example.enums.GameResult
import org.example.model.GameRound

class GameController(private val choiceGenerator: ChoiceGenerator) {

    fun playGame(): GameResult {
        return playRound(choiceGenerator.generateChoice(), choiceGenerator.generateChoice())
    }

    fun playCustomGame(opponentChoice: Choice): GameResult {
        return playRound(choiceGenerator.generateChoice(), opponentChoice)
    }

    fun playCustomGames(num: Int, opponentChoice: Choice): List<GameResult> {
        return List(num) { playRound(choiceGenerator.generateChoice(), opponentChoice) }
    }

    private fun playRound(player1Choice: Choice, player2Choice: Choice): GameResult {
        val gameRound = GameRound(player1Choice, player2Choice)
        return gameRound.getResult()
    }
}