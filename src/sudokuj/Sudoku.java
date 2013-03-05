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
public final class Sudoku {

    Cell[][] board;

    public Sudoku() {
        DefaultPuzzle defaultPuzzle = new DefaultPuzzle();
        board = DefaultPuzzle.getBoard();
        printBoard();
    }

    public Sudoku(Cell[][] b) {
        board = b;
    }

    public boolean conflict(int row, int col, int val) {
        for (int k = 0; k < 9; ++k) {
            if (val == board[k][col].getValue()) {
                return false;
            }
        }

        for (int k = 0; k < 9; ++k) {
            if (val == board[row][k].getValue()) {
                return false;
            }
        }

        int boxRowOffset = (row / 3) * 3;
        int boxColOffset = (col / 3) * 3;
        for (int k = 0; k < 3; ++k) {
            for (int m = 0; m < 3; ++m) {
                if (val == board[boxRowOffset + k][boxColOffset + m].getValue()) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public boolean rowContains(int row, int val) {
        for (int k = 0; k < 9; ++k) {
            if (val == board[row][k].getValue()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean colContains(int col, int val) {
        for (int k = 0; k < 9; ++k) {
            if (val == board[k][col].getValue()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean boxContains(int row, int col, int val) {
        int boxRowOffset = (row / 3) * 3;
        int boxColOffset = (col / 3) * 3;
        for (int k = 0; k < 3; ++k) {
            for (int m = 0; m < 3; ++m) {
                if (val == board[boxRowOffset + k][boxColOffset + m].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int findUnique(ArrayList<Integer> rowNeeds, ArrayList<Integer> colNeeds, ArrayList<Integer> boxNeeds) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if (rowNeeds.contains(i) && !colNeeds.contains(i) && !boxNeeds.contains(i)) {
                lis.add(rowNeeds.get(rowNeeds.indexOf(i)));
            } else if (!rowNeeds.contains(i) && colNeeds.contains(i) && !boxNeeds.contains(i)) {
                lis.add(colNeeds.get(colNeeds.indexOf(i)));
            } else if (!rowNeeds.contains(i) && !colNeeds.contains(i) && boxNeeds.contains(i)) {
                lis.add(boxNeeds.get(boxNeeds.indexOf(i)));
            }
        }
        
        if (lis.size() != 1) {
            System.out.println("No uniques here");
            System.out.print(lis);
            return -1;
        }
        
        return lis.get(0);
    }
    
    public boolean evaluate(int row, int col) {
        boolean didSomething = false;

        ArrayList<Integer> rowNeeds = new ArrayList<>();
        ArrayList<Integer> boxNeeds = new ArrayList<>();
        ArrayList<Integer> colNeeds = new ArrayList<>();
       
        for (int i = 1; i <= 9; i++) {
            if (!rowContains(row,i)) {
                rowNeeds.add(i);
            }
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!colContains(col,i)) {
                colNeeds.add(i);
            }
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!boxContains(row,col,i)) {
                boxNeeds.add(i);
            }
        }
        
        int ind = findUnique(rowNeeds,colNeeds,boxNeeds);
        if (ind != -1) {
            board[row][col].set(ind);
            didSomething = true;
        }
        
        return didSomething;
    }

    public boolean solve() {
        boolean wasThereAChange = false;
        boolean infinite = false;
        while (!infinite) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j].getValue() == 0) {
                        //System.out.println("Found a zero cell");
                        if (evaluate(i, j)) {
                            wasThereAChange = true;
                        }
                    }
                }
            }
            if (!wasThereAChange) {
                infinite = true;
            }
            wasThereAChange = false;
        }

        return !infinite;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" -----------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j].getValue() == 0 ? " " : Integer.toString(board[i][j].getValue()));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
