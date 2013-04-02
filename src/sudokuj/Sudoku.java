/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Travis
 */
public final class Sudoku {

    private static final boolean phaseTwo = true;
    
    Cell[][] board;
    int cellsToSolve;

    public void computeCellsToSolve() {
        int cells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 0; j++) {
                if (board[i][j].getValue() == 0) {
                    cells++;
                }
            }
        }
        cellsToSolve = cells;
    }
    
    public Sudoku() {
        DefaultPuzzle defaultPuzzle = new DefaultPuzzle();
        board = DefaultPuzzle.getBoard();
        printBoard();
    }

    public Sudoku(Cell[][] b) {
        //System.out.println(b.length);
        board = b;
        printBoard();
    }

    public boolean conflict(int row, int col, int val) {
        //System.out.println("Looking for conflict at: ("+row+","+col+") with value: "+val);
        for (int k = 0; k < 9; ++k) {
            if (val == board[k][col].getValue()) {
                return true;
            }
        }

        for (int k = 0; k < 9; ++k) {
            if (val == board[row][k].getValue()) {
                return true;
            }
        }

        int boxRowOffset = (row / 3) * 3;
        int boxColOffset = (col / 3) * 3;
        for (int k = 0; k < 3; ++k) {
            for (int m = 0; m < 3; ++m) {
                if (val == board[boxRowOffset + k][boxColOffset + m].getValue()) {
                    return true;
                }
            }
        }

        System.out.println("Looking for conflict at: (" + (row + 1) + "," + (col + 1) + ") with value: " + val + ". None detected.");

        return false;
    }

    public boolean boxNeeds(int n, int row, int col) {
        return !boxContains(row,col,n);
    }
    
    public boolean rowNeeds(int n, int row, int col) {
        return !rowContains(row,n);
    }
    
    public boolean colNeeds(int n, int row, int col) {
        return !colContains(col,n);
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

    public boolean checkPhaseOne(int row, int col) {
        boolean worked = false;
        
        if (board[row][col].empty()) {
            for (int i = 1; i < 10; i++) {
                if (!conflict(row,col,i)) {
                    board[row][col].setPot(i);
                    worked = true;
                }
            }
        } else if (board[row][col].getTotalPots() == 1) {
            board[row][col].set();
        } else {
            for (int i = 1; i < 10; i++) {
                if (conflict(row,col,i) && board[row][col].isPotential(i)) {
                    board[row][col].remove(i);
                    worked = true;
                }
            }
        }
        
        return worked;
    }
    
    public boolean checkPhaseTwo(int row, int col) {
        boolean worked = false;
        List<Integer> boxNeeds = new ArrayList<>();
        List<Integer> colNeeds = new ArrayList<>();
        List<Integer> rowNeeds = new ArrayList<>();
        
        //box
        for (int i = 1; i < 10; i++) {
            if (boxNeeds(i,row,col) && !conflict(row,col,i)) {
                boxNeeds.add(i);
            }
        }
        
        //row
        for (int i = 1; i < 10; i++) {
            if (rowNeeds(i,row,col) && !conflict(row,col,i)) {
                rowNeeds.add(i);
            }
        }
        
        //column
        for (int i = 1; i < 10; i++) {
            if (colNeeds(i,row,col) && !conflict(row,col,i)) {
                colNeeds.add(i);
            }
        }
        
        if (rowNeeds.size() == 1) {
            board[row][col].set(rowNeeds.get(0));
            worked = true;
        } else if (colNeeds.size() == 1) {
            board[row][col].set(colNeeds.get(0));
            worked = true;
        } else if (boxNeeds.size() == 1) {
            board[row][col].set(boxNeeds.get(0));
            worked = true;
        }
        
        return worked;
    }
    
    public boolean evaluate(int row, int col) {
        boolean didSomething = false;
        
        if (checkPhaseOne(row,col)) {
            didSomething = true;
        } else if (!phaseTwo) {
            didSomething  = checkPhaseTwo(row,col);
        }
        
        return didSomething;
    }

    public boolean solve() {
        boolean wasThereAChange = false;
        boolean infinite = false;
        boolean loop1 = false;
        boolean loop2 = false;
        while (!infinite) {
            computeCellsToSolve();
            System.out.println("Cells to solve: "+cellsToSolve);
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
            if (wasThereAChange) {
                loop1 = false;
                loop2 = false;
            } else if (!wasThereAChange && !loop1) {
                loop1 = true;
            } else if (!wasThereAChange && loop1 && !loop2) {
                loop2 = true;
            } else if (!wasThereAChange && loop1 && loop2) {
                infinite = true;
            }

            wasThereAChange = false;
        }

        return !infinite;
    }
    
    public boolean solved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].getValue() == 0) {
                    return false;
                }
            }
        }
        
        return true;
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
