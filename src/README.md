# Tic-Tac-Toe (Version 3.0: Command Pattern)
This version adds the **Command Design Pattern** to support "Undo" functionality.

**The Problem:** Right now, your game loop does this: board.addPiece(row, col, piece) This changes the board destructively. The previous state is lost forever. You cannot "go back."

**The Solution (Command Pattern):** We will stop making moves directly. instead, we will create Command Objects.

**The Command:** A class called MoveCommand that remembers where a piece was placed.

**The Stack:** A list of all past commands (History).

**The Undo:** When you want to go back, we take the last command from the stack and call its undo() method.


**Strategy Pattern:** Human vs Bot logic.

**Factory Pattern:** Clean Object Creation.

**Command Pattern:** Encapsulates moves as objects to allow `Ctrl+Z` (Undo).

### How it works:
Instead of modifying the board directly, we create `MoveCommand` objects.
`execute()`: Places the piece on the board.

`undo()`: Removes the piece from the board.
We store these commands in a `Stack` (History).
