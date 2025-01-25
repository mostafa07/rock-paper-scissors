package core

import org.example.core.ChoiceGenerator
import org.example.enums.Choice
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ChoiceGeneratorTest {

    @Test
    fun generateChoice_ShouldReturnOneOfRockOrPaperOrScissorsChoices() {
        val choice = ChoiceGenerator().generateChoice()
        assertTrue(choice in listOf(Choice.ROCK, Choice.PAPER, Choice.SCISSORS))
    }
}