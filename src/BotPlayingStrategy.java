public class BotPlayingStrategy implements PlayingStrategy {
    @Override
    public int[] makeMove(Board board){
        for(int i=0;i< board.size;i++){
            for(int j=0;j< board.size;j++) {
                if (board.board[i][j] == null) {
                    System.out.println("Found space at: "+ i+"," +j);
                    return new int[]{i,j};
                }
            }
        }
        return null; //not happen if we check hasFreeSpace beforehand
    }
}
