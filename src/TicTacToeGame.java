import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import  java.util.Stack;

public class TicTacToeGame{
    Deque<Player> players;
    Board gameBoard;
    Stack<Command> history = new Stack<>();

    public void initializeGame(){
        players = new LinkedList<>();

        Player p1 = PlayerFactory.createHumanPlayer("Player1",PieceType.X);
        Player p2 = PlayerFactory.createBotPlayer("Player2",PieceType.O);

        players.add(p1);
        players.add(p2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while(noWinner){

            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            //check if there are free spaces
            if(!gameBoard.hasFreeSpace()){
                noWinner = false;
                continue;
            }
            System.out.println("Player: "+ playerTurn.name + " turn.");
            // get the move
            int[] cell = playerTurn.playingStrategy.makeMove(gameBoard);

            // undo logic
            if(cell[0] == -1) {
                if (history.isEmpty()) {
                    System.out.println("Nothing to undo!");
                    players.addFirst(playerTurn);
                }

                Command lastCommand = history.pop();
                lastCommand.undo();
                System.out.println("Undo Successful");

                // now give turn back to previous player
                players.addFirst(playerTurn);
                Player previousPlayer = players.removeLast();
                players.addFirst(previousPlayer);
                continue;
            }

            int inputRow = cell[0];
            int inputCol = cell[1];
            //check if free
            if(!gameBoard.isCellFree(inputRow,inputCol)){
                System.out.println("Incorrect position please try again");
                players.addFirst(playerTurn);
                continue;
            }
            Command moveCommand = new MoveCommand(gameBoard,inputRow,inputCol,playerTurn.playingPiece);
            moveCommand.execute(); // adds the piece
            history.push(moveCommand); // save for undo

            //check for winner
            if(isThereWinner(inputRow,inputCol,playerTurn.playingPiece.type)){
                gameBoard.printBoard();
                return playerTurn.name;
            }
            players.addLast(playerTurn);
        }
        return "Tie";

    }
    public boolean isThereWinner(int row,int col,PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch= true;
        boolean antiDiagonalMatch = true;

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].type != pieceType){
                rowMatch= false;
            }
            if(gameBoard.board[i][col] == null || gameBoard.board[i][col].type != pieceType){
                columnMatch = false;
            }
        }
        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType){
                diagonalMatch= false;
            }
        }
        for(int i=0,j= gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType){
                antiDiagonalMatch= false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}