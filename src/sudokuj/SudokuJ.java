/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

/**
 *
 * @author Travis
 */
public class SudokuJ {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku sudo;
        sudo = new Sudoku();
        System.out.println("Solving naively");
        if (sudo.solve()) {
            sudo.printBoard();
        } else {
            System.out.println("Infinite loop detected.");
            sudo.printBoard();
        }
    }
}
