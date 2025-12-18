import java.util.Random;
import java.util.Scanner;

public class BirdRockWater {

    static int birdCount = 0;
    static int rockCount = 0;
    static int waterCount = 0;

    public static void greeting(Scanner scn, int money) {
        System.out.print("Enter your name: ");
        String name = scn.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Current Money: " + money + " rial");
        System.out.println("Let's play Bird - Rock - Water!");
        System.out.println("Type: bird / rock / water");
        System.out.println("Type !exit to quit");
    }

    public static int win(String computer) {
        System.out.println("You WIN! Computer chose " + computer);
        return 2000;
    }

    public static int lose(String computer) {
        System.out.println("You LOSE! Computer chose " + computer);
        return 0;
    }

    public static int draw(String computer) {
        System.out.println("DRAW! (" + computer + ")");
        return 1000;
    }

     static int playGame(String player, String computer) {
        if (player.equals(computer)) {
            return draw(computer);
        }
        if (player.equals("bird")) {
            return compupublicter.equals("rock") ? win(computer) : lose(computer);
        }
        if (player.equals("rock")) {
            return computer.equals("water") ? win(computer) : lose(computer);
        }
        if (player.equals("water")) {
            return computer.equals("bird") ? win(computer) : lose(computer);
        }
        return 0;
    }

    public static String getComputerChoice() {
        Random rand = new Random();

        if (birdCount >= rockCount && birdCount >= waterCount) {
            return rand.nextInt(100) < 60 ? "water"
                    : rand.nextBoolean() ? "bird" : "rock";
        }

        if (rockCount >= birdCount && rockCount >= waterCount) {
            return rand.nextInt(100) < 60 ? "bird"
                    : rand.nextBoolean() ? "rock" : "water";
        }

        if (waterCount >= birdCount && waterCount >= rockCount) {
            return rand.nextInt(100) < 60 ? "rock"
                    : rand.nextBoolean() ? "bird" : "water";
        }

        String[] choices = {"bird", "rock", "water"};
        return choices[rand.nextInt(3)];
    }

    public static String getRank(int money) {
        if (money >= 10000) return "SPD No.1";
        if (money >= 5000) return "P'Keng hor!!!";
        if (money >= 1000) return "Penguin";
        return "No Rank";
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int money = 0;
        int totalGames = 0;
        int win = 0, lose = 0, draw = 0;

        greeting(scn, money);

        while (true) {
            System.out.print("> ");
            String choice = scn.nextLine();

            if (choice.equals("!exit")) {
                System.out.println("\n=== GAME SUMMARY ===");
                System.out.println("Money: " + money + " rial");
                System.out.println("Rank: " + getRank(money));
                System.out.println("Games: " + totalGames);
                System.out.println("Wins: " + win);
                System.out.println("Draws: " + draw);
                System.out.println("Loses: " + lose);
                System.out.println("Bye!");
                break;
            }

            if (!(choice.equals("bird") || choice.equals("rock") || choice.equals("water"))) {
                System.out.println("Enter input");
                continue;
            }

            if (choice.equals("bird")) birdCount++;
            if (choice.equals("rock")) rockCount++;
            if (choice.equals("water")) waterCount++;

            String computer = getComputerChoice();
            int result = playGame(choice, computer);

            money += result;
            totalGames++;

            if (result == 2000) win++;
            else if (result == 1000) draw++;
            else lose++;

            System.out.println("Money: " + money + " rial | Rank: " + getRank(money));
        }

        scn.close();
    }
}
