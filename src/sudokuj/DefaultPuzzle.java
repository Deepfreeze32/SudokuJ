/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;
import sudokuj.Cell;

/**
 *
 * @author Travis
 */
public class DefaultPuzzle {
    private static Cell[][] board;
    
    public DefaultPuzzle() {
        board = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            //ArrayList<Cell> row = new ArrayList<>();
            int j = 0;
            if (i == 0) {
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(9);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(7);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(4);
            } else if (i == 1) {
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(8);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(1);
                board[i][j++] = new Cell(5);
                board[i][j++] = new Cell(7);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(3);
            } else if (i == 2) {
                board[i][j++] = new Cell(3);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(9);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(8);
                board[i][j++] = new Cell();
            } else if (i == 3) {
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(3);
                board[i][j++] = new Cell(5);
            } else if (i == 4) {
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(8);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(5);
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(4);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(2);
                board[i][j++] = new Cell();
            } else if (i == 5) {
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(9);
                board[i][j++] = new Cell(5);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
            } else if (i == 6) {
                board[i][j++] = new Cell(9);
                board[i][j++] = new Cell(1);
                board[i][j++] = new Cell(2);
                board[i][j++] = new Cell(4);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(3);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(6);
            } else if (i == 7) {
                board[i][j++] = new Cell(7);
                board[i][j++] = new Cell(3);
                board[i][j++] = new Cell(6);
                board[i][j++] = new Cell(1);
                board[i][j++] = new Cell(9);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(4);
                board[i][j++] = new Cell(5);
                board[i][j++] = new Cell();
            } else if (i == 8) {
                board[i][j++] = new Cell(8);
                board[i][j++] = new Cell(5);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(3);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell(2);
                board[i][j++] = new Cell();
                board[i][j++] = new Cell();
            }
            //board.add(row);
        }
    }
    
    public static Cell[][] getBoard() {
        return board;
    }
}
