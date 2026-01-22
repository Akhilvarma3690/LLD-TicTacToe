public class StatsWatcher implements GameObserver{
    int moveCount = 0;
    @Override
    public void onGameEvent(String message){
        if(message.contains("moved")){
            moveCount++;
            System.out.println("[STATS BOARD]: Total moves so far:" + moveCount);
        }
        else if(message.contains("won")){
            System.out.println("[STATS BOARD]: Game Over! winner is " + message);
        }
    }
}
