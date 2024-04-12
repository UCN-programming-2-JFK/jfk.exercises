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
- [SudokuWindow.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/sudoku/ui/SudokuWindow.java) has a [SudokuSolutionWindow.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/solutions/SudokuSolutionWindow.java) subclass 
- [MazeFrame.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/maze/ui/MazeFrame.java) has a [MazeFrameSolution.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/solutions/MazeFrameSolutionWindow.java) subclass 
- [BoardFrame.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/skeletons/eightqueens/ui/BoardFrame.java) has a [MazeFrameSolution.java](https://github.com/UCN-programming-2-JFK/jfk.exercises/blob/master/src/jfk/exercises/solutions/EightQueenSolutionWindow.java) subclass 

...all of which have an implementation of the `solve()` method.  
![image](https://user-images.githubusercontent.com/3811290/200328362-470976bf-8628-499a-ad1f-2b28a2f70a15.png)
![image](https://user-images.githubusercontent.com/3811290/200328340-8edf18b6-33a4-4ae3-9752-432f42fbe483.png)
![image](https://user-images.githubusercontent.com/3811290/200328432-e5c3a156-623d-4ce6-a118-1c940f11c820.png)

