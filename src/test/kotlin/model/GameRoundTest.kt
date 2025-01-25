package model

import org.example.enums.Choice
import org.example.enums.GameResult
import org.example.model.GameRound
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameRoundTest {

    // Tie Game Tests

    @Test
    fun getResult_RockVsRock_ShouldReturnTie() {
        val gameRound = GameRound(Choice.ROCK, Choice.ROCK)
        assertEquals(GameResult.TIE, gameRound.getResult())
    }

    @Test
    fun getResult_PaperVsPaper_ShouldReturnTie() {
        val gameRound = GameRound(Choice.PAPER, Choice.PAPER)
        assertEquals(GameResult.TIE, gameRound.getResult())
    }

    @Test
    fun getResult_ScissorsVsScissors_ShouldReturnTie() {
        val gameRound = GameRound(Choice.SCISSORS, Choice.SCISSORS)
        assertEquals(GameResult.TIE, gameRound.getResult())
    }

    // Win Game Tests

    @Test
    fun getResult_RockVsScissors_ShouldReturnWin() {
        val gameRound = GameRound(Choice.ROCK, Choice.SCISSORS)
        assertEquals(GameResult.WIN, gameRound.getResult())
    }

    @Test
    fun getResult_PaperVsRock_ShouldReturnWin() {
        val gameRound = GameRound(Choice.PAPER, Choice.ROCK)
        assertEquals(GameResult.WIN, gameRound.getResult())
    }

    @Test
    fun getResult_ScissorsVsPaper_ShouldReturnWin() {
        val gameRound = GameRound(Choice.SCISSORS, Choice.PAPER)
        assertEquals(GameResult.WIN, gameRound.getResult())
    }

    // Lose Game Tests

    @Test
    fun getResult_RockVsPaper_ShouldReturnLose() {
        val gameRound = GameRound(Choice.ROCK, Choice.PAPER)
        assertEquals(GameResult.LOSE, gameRound.getResult())
    }

    @Test
    fun getResult_PaperVsScissors_ShouldReturnLose() {
        val gameRound = GameRound(Choice.PAPER, Choice.SCISSORS)
        assertEquals(GameResult.LOSE, gameRound.getResult())
    }

    @Test
    fun getResult_ScissorsVsRock_ShouldReturnLose() {
        val gameRound = GameRound(Choice.SCISSORS, Choice.ROCK)
        assertEquals(GameResult.LOSE, gameRound.getResult())
    }
}