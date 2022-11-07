# jfk.exercises
This project contains UI for visualization of three different problems with a common solution.  
Using the [Backtracking algorithm](https://www.geeksforgeeks.org/backtracking-algorithms/) it is possible to solve many different problems.  

With this Eclipse project the students get skeleton code for three different problems
- Solve a Sudoku
- Solve a maze
- Solve the [8 queen puzzle](https://en.wikipedia.org/wiki/Eight_queens_puzzle)

All three skeletons have a JFrame implementation which contains
- a JPanel subclass which can visualize the problem/solution in question
- an unimplemented `solve()` method

## The exercise
The exercise for the student is to implement the solve() method, so it fulfills the requirements for that type of task.  
The JPanel visualizer can then be used to show the solution achieved using the backtracking (or in reality any other) algorithm.

## The solutions
The solutions are implemented as subclasses of the respective JFrame subclasses, so 
- [SudokuWindow.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/sudoku/ui/SudokuWindow.java) has a [SudokuSolutionWindow.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/solutions/SudokuSolutionWindow.java) subclass 
- [MazeFrame.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/maze/ui/MazeFrame.java) has a [MazeFrameSolution.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/solutions/MazeFrameSolutionWindow.java) subclass 
- [BoardFrame.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/eightqueens/ui/BoardFrame.java) has a [MazeFrameSolution.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/solutions/EightQueenSolutionWindow.java) subclass 
