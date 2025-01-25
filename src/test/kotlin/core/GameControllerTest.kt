package core

import org.example.core.ChoiceGenerator
import org.example.enums.Choice
import org.example.enums.GameResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GameControllerTest {

    private val choiceGenerator = mock(ChoiceGenerator::class.java)
    private val gameController = GameController(choiceGenerator)

    @Test
    fun playGame_RockVsRock_ShouldReturnTie() {
        `when`(choiceGenerator.generateChoice()).thenReturn(Choice.ROCK)
        assertEquals(GameResult.TIE, gameController.playGame())
    }


    @Test
    fun playCustomGame_RockVsRock_ShouldReturnTie() {
        `when`(choiceGenerator.generateChoice()).thenReturn(Choice.ROCK)
        assertEquals(GameResult.TIE, gameController.playCustomGame(Choice.ROCK))
    }

    @Test
    fun playCustomGame_PaperVsRock_ShouldReturnTie() {
        `when`(choiceGenerator.generateChoice()).thenReturn(Choice.PAPER)
        assertEquals(GameResult.WIN, gameController.playCustomGame(Choice.ROCK))
    }

    @Test
    fun playCustomGame_ScissorsVsRock_ShouldReturnTie() {
        `when`(choiceGenerator.generateChoice()).thenReturn(Choice.SCISSORS)
        assertEquals(GameResult.LOSE, gameController.playCustomGame(Choice.ROCK))
    }


    @Test
    fun playCustomGames_100GamesOfPaperVsRock_ShouldReturn100Wins() {
        `when`(choiceGenerator.generateChoice()).thenReturn(Choice.PAPER)
        val results = gameController.playCustomGames(100, Choice.ROCK)
        assertEquals(100, results.count { it == GameResult.WIN })
    }
}