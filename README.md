Project Description
===================

This is a Sudoku solver written in Java for CS 467: Introduction  
to Artificial Intelligence. 

Files
-----

sudoku.pl is a prolog solver I have included as a bonus! 

Instructions
------------

First run the following commands from the project root: cd src/sudokuj/  
javac Cell.java DefaultPuzzle.java PuzzleParser.java Sudoku.java SudokuJ.java  
cd ../  
java sudokuj.SudokuJ <parameters>  

Valid parameters are: A Sudoku puzzle in the specified format. No parameters will  
run the simple example I provided. A puzzle must be input in the following form:  
[row1][row2][row3][row4][row5][row6][row7][row8]  
Example: java sudoku.SudokuJ 009070064068015703300609080000000635080564020695000000912400306736190450850030200
