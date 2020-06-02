package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RockTest {

    private RulesOfGame rock = new RulesOfGame.Rock();

    @Tag("Rock")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  20,  0",
            "-1, -1, -21, -1",
            "-1,  4, -1,   10 ",
            " 0,  1,  0,  -1 ",
    })
    void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rock.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,   -2",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rock.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
