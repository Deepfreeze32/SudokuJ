/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

/**
 *
 * @author tcc10a
 */
public class PuzzleParser {
    static boolean solved;
    
    private static Cell[][] convertOneDimensionalToTwoDimensional(int numberOfRows, int rowSize, Cell[] srcMatrix) {
        int srcMatrixLength = srcMatrix.length;
        int srcPosition = 0;

        Cell[][] returnMatrix = new Cell[numberOfRows][];
        for (int i = 0; i < numberOfRows; i++) {
            Cell[] row = new Cell[rowSize];
            int nextSrcPosition = srcPosition + rowSize;
            if (srcMatrixLength >= nextSrcPosition) {
                // Copy the data from the file if it has been written before. Otherwise we just keep row empty.
                System.arraycopy(srcMatrix, srcPosition, row, 0, rowSize);
            }
            returnMatrix[i] = row;
            srcPosition = nextSrcPosition;
        }
        return returnMatrix;
    }
    
    public static Cell[][] parseProblem(String problem) {
        solved = true;
        Cell[][] board;
        Cell[] temp = new Cell[81];
        for (int i = 0; i < 81; i++) {
            char a = problem.charAt(i);
            int b = Character.getNumericValue(a);
            if (b == 0) {
                solved = false;
            }
            temp[i] = new Cell(b);
        }
        board = convertOneDimensionalToTwoDimensional(9,9,temp);
        return board;
    }
    
    public static boolean isSolved() {
        return solved;
    }
}
