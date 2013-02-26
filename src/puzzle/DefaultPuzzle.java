/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import sudokuj.Cell;

/**
 *
 * @author Travis
 */
public class DefaultPuzzle {
    private static ArrayList<ArrayList<Cell>> board;
    
    public DefaultPuzzle() {
        for (int i = 0; i < 9; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            if (i == 0) {
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(9));
                row.add(new Cell());
                row.add(new Cell(7));
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(6));
                row.add(new Cell(4));
            } else if (i == 1) {
                row.add(new Cell());
                row.add(new Cell(6));
                row.add(new Cell(8));
                row.add(new Cell());
                row.add(new Cell(1));
                row.add(new Cell(5));
                row.add(new Cell(7));
                row.add(new Cell());
                row.add(new Cell(3));
            } else if (i == 2) {
                row.add(new Cell(3));
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(9));
                row.add(new Cell());
                row.add(new Cell(8));
                row.add(new Cell());
            } else if (i == 3) {
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(3));
                row.add(new Cell(5));
            } else if (i == 4) {
                row.add(new Cell());
                row.add(new Cell(8));
                row.add(new Cell());
                row.add(new Cell(5));
                row.add(new Cell(6));
                row.add(new Cell(4));
                row.add(new Cell());
                row.add(new Cell(2));
                row.add(new Cell());
            } else if (i == 5) {
                row.add(new Cell(6));
                row.add(new Cell(9));
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
            } else if (i == 6) {
                row.add(new Cell());
                row.add(new Cell(1));
                row.add(new Cell());
                row.add(new Cell(4));
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(6));
            } else if (i == 7) {
                row.add(new Cell(7));
                row.add(new Cell());
                row.add(new Cell(6));
                row.add(new Cell(1));
                row.add(new Cell(9));
                row.add(new Cell());
                row.add(new Cell(4));
                row.add(new Cell(5));
                row.add(new Cell());
            } else if (i == 8) {
                row.add(new Cell(8));
                row.add(new Cell(5));
                row.add(new Cell());
                row.add(new Cell());
                row.add(new Cell(3));
                row.add(new Cell());
                row.add(new Cell(2));
                row.add(new Cell());
                row.add(new Cell());
            }
            board.add(row);
        }
    }
    
    public static ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }
}
