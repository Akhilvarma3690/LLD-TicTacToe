# Tic-Tac-Toe (Version 1: Basic)
This is a simple console-based Tic-Tac-Toe game built in Java.
**Logic:** All game flow logic is inside the TicTacToeGame class.
**Pattern:** No specific design patterns used yet (Monolithic logic).
**Features:** Supports 2 Human Players on a 3x3 Grid.

## Current Design (UML)
```mermaid
classDiagram
class Main {
+main(args)
}

    class TicTacToeGame {
        -Deque~Player~ players
        -Board gameBoard
        +initializeGame()
        +startGame() String
        -isThereWinner(row, col, pieceType) boolean
    }

    class Board {
        +int size
        +PlayingPiece[][] board
        +addPiece(row, col, piece) boolean
        +printBoard()
        +hasFreeSpace() boolean
    }

    class Player {
        +String name
        +PlayingPiece playingPiece
    }

    class PlayingPiece {
        +PieceType type
    }

    class PieceType {
        <<enumeration>>
        X
        O
    }

    Main --> TicTacToeGame : creates
    TicTacToeGame *-- Board : has-a
    TicTacToeGame o-- Player : has-players
    Player o-- PlayingPiece : holds
    PlayingPiece --> PieceType : uses
    Board *-- PlayingPiece : stores
```