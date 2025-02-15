package core

import org.example.core.ChoiceGenerator
import org.example.enums.Choice.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest

class ChoiceGeneratorTest {

    @RepeatedTest(1000)
    fun generateChoice_ShouldReturnOneOfRockOrPaperOrScissorsOrLizardOrSpockChoices() {
        val choice = ChoiceGenerator().generateChoice()
        assertTrue(choice in listOf(ROCK, PAPER, SCISSORS, LIZARD, SPOCK))
    }
}