public class MoveCommand implements Command{
    Board board;
    int row;
    int col;
    PlayingPiece piece;

    public MoveCommand(Board board,int row,int col,PlayingPiece piece){
        this.board = board;
        this.row = row;
        this.col = col;
        this.piece = piece;
    }
    @Override
    public void execute(){
        board.addPiece(row,col,piece);
    }

    @Override
    public void undo() {
        board.removePiece(row,col);
    }
}
