# Tic-Tac-Toe (Version 2.1: Factory Pattern)
This version adds the **Factory Design Pattern** to the existing Strategy Pattern implementation.

### The Problem: "Creation Complexity"
In the previous version, the `TicTacToeGame` class (the Client) had to know **too much** about how to build a player. It had to:
1. Create the `PlayingPiece`.
2. Select the right `PieceType`.
3. Select the right `PlayingStrategy`.
4. Pass them all into the `Player` constructor correctly.

**The messy code:**
```java
Player p = new Player("Name", new PlayingPiece(PieceType.X), new HumanPlayingStrategy());