package model

import org.example.enums.GameResult
import org.example.model.GameStats
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameStatsTest {

    private val gameStats: GameStats = GameStats(
        listOf(
            GameResult.WIN,
            GameResult.WIN,
            GameResult.TIE,
            GameResult.WIN,
            GameResult.LOSE,
            GameResult.TIE,
            GameResult.LOSE
        )
    )

    @Test
    fun getNumWins_ShouldReturn3() {
        assertEquals(3, gameStats.getNumWins())
    }

    @Test
    fun getNumLosses_ShouldReturn2() {
        assertEquals(2, gameStats.getNumLosses())
    }

    @Test
    fun getNumTies_ShouldReturn2() {
        assertEquals(2, gameStats.getNumTies())
    }
}