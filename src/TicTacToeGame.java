import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class TicTacToeGame{
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();

        PlayingPiece cross=new PlayingPiece(PieceType.X);
        Player p1=new Player("p1",cross);

        PlayingPiece nought=new PlayingPiece(PieceType.O);
        Player p2=new Player("p2",nought);

        players.add(p1);
        players.add(p2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while(noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            System.out.print("Player: "+ playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s= inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceadded= gameBoard.addPiece(inputRow, inputCol,playerTurn.playingPiece);
            if(pieceadded){
                boolean winner=isThereWinner(inputRow,inputCol,playerTurn.playingPiece.type);
                if(winner){
                    gameBoard.printBoard();
                    return playerTurn.name;
                }
            }
            //Chech for tie (board full)
            if(!gameBoard.hasFreeSpace()){
                gameBoard.printBoard();
                return "tie";
            }
            if(!pieceadded){
                System.out.println("Incorrect Position Chosen, try again");
                players.addFirst(playerTurn);
                continue; // skip below
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