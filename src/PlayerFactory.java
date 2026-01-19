public class PlayerFactory {
    //1. Factory method to create Human Player
    // we make it 'static' so we don't need to create an instance of factory itself.
    public static Player createHumanPlayer(String name,PieceType type){
        PlayingPiece piece = new PlayingPiece(type);
        PlayingStrategy strategy = new HumanPlayingStrategy();
        return new Player(name,piece,strategy);
    }
    // 2. Factory method to create bot
    public static Player createBotPlayer(String name,PieceType type){
        PlayingPiece piece = new PlayingPiece(type);
        PlayingStrategy strategy = new BotPlayingStrategy();
        return new Player(name,piece,strategy);
    }
}
