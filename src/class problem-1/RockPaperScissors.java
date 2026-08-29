import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();
            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);
            System.out.println("Round " + i + ": Player = " +
                    player + ", Computer = " + computer + " → " + result);
            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }
        double percentage = (wins * 100.0) / 5;
        System.out.println("\nWins: " + wins +
                " | Losses: " + losses +
                " | Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");
        sc.close();
    }
}