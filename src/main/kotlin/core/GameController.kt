package core

import org.example.core.ChoiceGenerator
import org.example.enums.Choice
import org.example.enums.GameResult
import org.example.model.GameRound

class GameController(private val choiceGenerator: ChoiceGenerator) {

    fun playGame(): GameResult {
        val gameRound = GameRound(choiceGenerator.generateChoice(), choiceGenerator.generateChoice())
        return gameRound.getResult()
    }

    fun playCustomGame(opponentChoice: Choice): GameResult {
        val gameRound = GameRound(choiceGenerator.generateChoice(), opponentChoice)
        return gameRound.getResult()
    }

    fun playCustomGames(num: Int, opponentChoice: Choice): List<GameResult> {
        val gameResults = mutableListOf<GameResult>()
        repeat(num) {
            gameResults.add(playCustomGame(opponentChoice))
        }
        return gameResults
    }
}