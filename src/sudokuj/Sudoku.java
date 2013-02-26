/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;
import puzzle.DefaultPuzzle;

/**
 *
 * @author Travis
 */
public class Sudoku {
    ArrayList<ArrayList<Cell>> board;
    
    public Sudoku() {
        board = DefaultPuzzle.getBoard();
    }
    
    
}
