package model

import org.example.enums.Choice
import org.example.enums.GameResult
import org.example.model.GameRound
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

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

    @Test
    fun getResult_LizardVsLizard_ShouldReturnTie() {
        val gameRound = GameRound(Choice.LIZARD, Choice.LIZARD)
        assertEquals(GameResult.TIE, gameRound.getResult())
    }

    @Test
    fun getResult_SpockVsSpock_ShouldReturnTie() {
        val gameRound = GameRound(Choice.SPOCK, Choice.SPOCK)
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

    // Smart Unit Test Testing for all Possible Game Combinations (This is written by GitHub Copilot)

    @TestFactory
    fun allPossibleGameRounds(): List<DynamicTest> {
        val choices = Choice.entries.toTypedArray()
        val expectedResults = mapOf(
            Pair(Choice.ROCK, Choice.ROCK) to GameResult.TIE,
            Pair(Choice.ROCK, Choice.PAPER) to GameResult.LOSE,
            Pair(Choice.ROCK, Choice.SCISSORS) to GameResult.WIN,
            Pair(Choice.ROCK, Choice.LIZARD) to GameResult.WIN,
            Pair(Choice.ROCK, Choice.SPOCK) to GameResult.LOSE,
            Pair(Choice.PAPER, Choice.ROCK) to GameResult.WIN,
            Pair(Choice.PAPER, Choice.PAPER) to GameResult.TIE,
            Pair(Choice.PAPER, Choice.SCISSORS) to GameResult.LOSE,
            Pair(Choice.PAPER, Choice.LIZARD) to GameResult.LOSE,
            Pair(Choice.PAPER, Choice.SPOCK) to GameResult.WIN,
            Pair(Choice.SCISSORS, Choice.ROCK) to GameResult.LOSE,
            Pair(Choice.SCISSORS, Choice.PAPER) to GameResult.WIN,
            Pair(Choice.SCISSORS, Choice.SCISSORS) to GameResult.TIE,
            Pair(Choice.SCISSORS, Choice.LIZARD) to GameResult.WIN,
            Pair(Choice.SCISSORS, Choice.SPOCK) to GameResult.LOSE,
            Pair(Choice.LIZARD, Choice.ROCK) to GameResult.LOSE,
            Pair(Choice.LIZARD, Choice.PAPER) to GameResult.WIN,
            Pair(Choice.LIZARD, Choice.SCISSORS) to GameResult.LOSE,
            Pair(Choice.LIZARD, Choice.LIZARD) to GameResult.TIE,
            Pair(Choice.LIZARD, Choice.SPOCK) to GameResult.WIN,
            Pair(Choice.SPOCK, Choice.ROCK) to GameResult.WIN,
            Pair(Choice.SPOCK, Choice.PAPER) to GameResult.LOSE,
            Pair(Choice.SPOCK, Choice.SCISSORS) to GameResult.WIN,
            Pair(Choice.SPOCK, Choice.LIZARD) to GameResult.LOSE,
            Pair(Choice.SPOCK, Choice.SPOCK) to GameResult.TIE
        )

        return choices.flatMap { player1Choice ->
            choices.map { player2Choice ->
                DynamicTest.dynamicTest("Test $player1Choice vs $player2Choice") {
                    val gameRound = GameRound(player1Choice, player2Choice)
                    val expectedResult = expectedResults[Pair(player1Choice, player2Choice)]
                    assertEquals(expectedResult, gameRound.getResult())
                }
            }
        }
    }
}