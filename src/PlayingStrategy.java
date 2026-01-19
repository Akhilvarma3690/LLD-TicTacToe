public interface PlayingStrategy{
    //we pass board so strategy can decide to make a move
    // return row,col array
    int[] makeMove(Board board);
}