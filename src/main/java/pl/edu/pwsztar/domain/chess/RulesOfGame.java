package pl.edu.pwsztar.domain.chess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * (xStart, yStart) na (xEnd, yEnd) w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd);

    @Component
    @Qualifier("Bishop")
    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if(xStart == xEnd && yStart == yEnd) {
                return false;
            }

            return Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart);
        }
    }

    @Component
    @Qualifier("Knight")
    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if((xStart == xEnd) && (yStart == yEnd)){
                return false;
            }

            int row = Math.abs(xEnd - xStart);
            int col = Math.abs(yEnd - yStart);
            return ((row == 2 && col == 1) || (row == 1 && col == 2));
        }
    }

    @Component
    @Qualifier("King")
    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if((xStart == xEnd) && (yStart == yEnd)){
                return false;
            }
            int x = Math.abs(xEnd - xStart);
            int y = Math.abs(yEnd - yStart);
            return ((x == 0 || x == 1) && (y == 0 || y == 1));
        }
    }

    @Component
    @Qualifier("Queen")
    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if((xStart == xEnd) && (yStart == yEnd)){
                return false;
            }

            return Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart) || xStart == xEnd || yStart == yEnd;
        }
    }

    @Component
    @Qualifier("Rock")
    class Rock implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if((xStart == xEnd) && (yStart == yEnd)){
                return false;
            }

            return ((xStart == xEnd) || (yStart == yEnd));
        }
    }

    @Component
    @Qualifier("Pawn")
    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if((xStart == xEnd) && (yStart == yEnd)){
                return false;
            }
            return (yEnd - yStart) == 1;
        }
    }

}
