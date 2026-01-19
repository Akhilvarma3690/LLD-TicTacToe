public class Player {
    PlayingPiece playingPiece;
    String name;
    PlayingStrategy playingStrategy;

    public Player(String name,PlayingPiece playingPiece,PlayingStrategy playingStrategy){
        this.playingPiece=playingPiece;
        this.name=name;
        this.playingStrategy=playingStrategy;
    }
}