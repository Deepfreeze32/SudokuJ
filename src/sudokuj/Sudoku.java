/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuj;

import java.util.ArrayList;
import java.util.List;
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
    
    public int getBoxNumber(int row, int col) {
        int box;
        if (row > 9 || row < 1 || col > 9 || col < 9) {
            box = 0;
        } else {
            if (col < 3 && row < 3) {
                box = 1;
            } else if (col < 6 && row < 3) {
                box = 2;
            } else if (col < 9 && row < 3) {
                box = 3;
            } else if (col < 3 && row < 6) {
                box = 4;
            } else if (col < 6 && row < 6) {
                box = 5;
            } else if (col < 9 && row < 3) {
                box = 6;
            } else if (col < 3 && row < 9) {
                box = 7;
            } else if (col < 6 && row < 9) {
                box = 8;
            } else {
                box = 9;
            }
        }
        return box;
    }
    
    public List<Integer> getBoxGroups(int box) {
        List<Integer> l = new ArrayList<>();
        if (box == 1) {
            l.add(2);
            l.add(3);
            l.add(4);
            l.add(7);
        } else if (box == 2) {
            l.add(1);
            l.add(3);
            l.add(5);
            l.add(8);
        } else if (box == 3) {
            l.add(1);
            l.add(2);
            l.add(6);
            l.add(9);
        } else if (box == 4) {
            l.add(1);
            l.add(5);
            l.add(6);
            l.add(7);
        } else if (box == 5) {
            l.add(2);
            l.add(4);
            l.add(6);
            l.add(8);
        } else if (box == 7) {
            l.add(1);
            l.add(4);
            l.add(8);
            l.add(9);
        } else if (box == 8) {
            l.add(2);
            l.add(5);
            l.add(7);
            l.add(9);
        } else if (box == 9) {
            l.add(3);
            l.add(6);
            l.add(7);
            l.add(8);
        }
        return l;
    }

    public int findUnique(List<Integer> rowNeeds, List<Integer> colNeeds, List<Integer> boxNeeds) {
        List<Integer> lis = new ArrayList<>();
        //System.out.print(lis);
        System.out.println("\nRow needs: ");
        System.out.print(rowNeeds);
        System.out.println("\nColumn needs: ");
        System.out.print(colNeeds);
        System.out.println("\nBox needs: ");
        System.out.print(boxNeeds);
        System.out.println();
        
        if (rowNeeds.size() == 1) {
            return rowNeeds.get(0);
        } else if (colNeeds.size() == 1) {
            return colNeeds.get(0);
        } else if (boxNeeds.size() == 1) {
            return boxNeeds.get(0);
        }
        
        for (int i = 1; i <= 9; i++) {
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
            System.out.println();
            return -1;
        }
        System.out.println("Unique Element found:" + lis.get(0));
        System.out.print(lis);
        System.out.println();
        return lis.get(0);
    }

    public boolean evaluate(int row, int col) {
        boolean didSomething = false;

        List<Integer> nonConflicting = new ArrayList<>();

        List<Integer> rowNeeds = new ArrayList<>();
        List<Integer> boxNeeds = new ArrayList<>();
        List<Integer> colNeeds = new ArrayList<>();

        int groupRowOffset = (row / 3) * 3;
        int groupColOffset = (col / 3) * 3;
        
        for (int i = 1; i <= 9; i++) {
            if (!conflict(row, col, i)) {
                nonConflicting.add(i);
            }
        }

        for (int i = 0; i < nonConflicting.size(); i++) {
            if (!rowContains(row, nonConflicting.get(i))) {
                rowNeeds.add(nonConflicting.get(i));
            }
        }

        for (int i = 0; i < nonConflicting.size(); i++) {
            if (!colContains(col, i)) {
                colNeeds.add(nonConflicting.get(i));
            }
        }

        for (int i = 0; i < nonConflicting.size(); i++) {
            if (!boxContains(row, col, nonConflicting.get(i))) {
                boxNeeds.add(nonConflicting.get(i));
            }
        }

        int ind = findUnique(rowNeeds, colNeeds, boxNeeds);
        if (ind != -1) {
            board[row][col].set(ind);
            printBoard();
            didSomething = true;
        }

        return didSomething;
    }

    public boolean solve() {
        boolean wasThereAChange = false;
        boolean infinite = false;
        boolean loop1 = false;
        boolean loop2 = false;
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
