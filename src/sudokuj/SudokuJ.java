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
        
        if (args.length == 1) {
            sudo = new Sudoku(PuzzleParser.parseProblem(args[0]));
            if (PuzzleParser.isSolved()) {
                System.out.println("Solved! Here is the solution:");
                sudo.printBoard();
                return;
            }
        } else {
            sudo = new Sudoku();
        }
        System.out.println("Solving naively");
        sudo.solve();
        if (sudo.solved()) {
            System.out.println("Solved! Here is the solution:");
            sudo.printBoard();
        } else {
            System.out.println("Infinite loop detected. No solution.");
            sudo.printBoard();
        }
    }
}
