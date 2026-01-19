public class Main{
    public static void main(String[] args){
        TicTacToeGame game=new TicTacToeGame();
        game.initializeGame();
        System.out.println("Game Initialization setup complete");
        String res = game.startGame();
        System.out.println(res);
    }
}