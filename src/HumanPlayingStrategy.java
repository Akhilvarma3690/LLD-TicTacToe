import java.util.Scanner;

public class HumanPlayingStrategy implements PlayingStrategy{
    @Override
    public int[] makeMove(Board board){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter row,column : ");
        String s=inputScanner.nextLine();
        String[] values=s.split(",");
        int row= Integer.valueOf(values[0]);
        int col= Integer.valueOf(values[1]);
        return new int[]{row,col};
    }
}