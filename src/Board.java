public class Board{
    public int size;
    public PlayingPiece[][] board;
    public Board(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] != null){
                System.out.print(board[i][j].type +" | ");
                }else{
                    System.out.print("  | ");
                }
            }
            System.out.println(); // new line after each row
        }
    }
    public boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] != null){
            return false;
        }
        board[row][col] = piece;
        return true;
    }
    public void removePiece(int row,int col){
        board[row][col]=null;
    }

    public boolean hasFreeSpace(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCellFree(int row,int col){
        return board[row][col] == null;
    }
}
