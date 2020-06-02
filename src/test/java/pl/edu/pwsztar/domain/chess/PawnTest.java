package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    private RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            " 0,  0, 0,  1",
            "-1, -1, -1, 0",
            " 4,  4, 4,  5",
            " 12, 1, 12, 2",
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,   -2",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
