
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
//        create list - this game don't need ArrayList
//        ArrayList<Integer> ListNums = new ArrayList<Integer>();

        int moves = 0;
        int low = 1;
        int high = 100;
        int score = 10;
        String flag = null;
        int number = r.nextInt(101) + 1;
        System.out.println("Super number " + number);
        System.out.println("*================================*");
        System.out.println(" Welcome to Guessing number Game");
        System.out.println("*================================*");
        System.out.println("**If any time want to exit the game type: esc**");

        while (true) {

            System.out.printf("\nPlease provide a number between %d και %d: ", low, high);
            String input = sc.nextLine();

            if (checkInt(input)) {
                int validInput = Integer.parseInt(input);
                ListNums.add(validInput);
                if (validInput < low || validInput > high) {
                    System.out.printf("You didn'tprovide a number between %d και %d, try again!", low, high);
                    moves += 1;
                    continue;
                }

                if (validInput == number) {
                    moves += 1;
                    score -= moves;
                    System.out.println("Cogratulations you found the hidden number!!!");
                    System.out.printf("Moves: %d. Score: %d. ", moves, score);

                    while (true) {
                        System.out.println("\n\nWanna play again? (Y/N)");
                        flag = sc.nextLine();
                        if (flag.equalsIgnoreCase("Y") || flag.equalsIgnoreCase("N")) {
                            break;
                        }
                        System.out.println("Sorry, didn't understand...");
                        continue;
                    }
                    if (flag.equalsIgnoreCase("Y")) {
                        moves = 0;
                        low = 0;
                        high = 100;
                        score = 10;
                        number = r.nextInt(101) + 1;
                        System.out.println("Super number " + number);
                        continue;
                    } else if (flag.equalsIgnoreCase("N")) {
                        System.out.println("Thank you for playing!!");
                        break;
                    }
                }

                if (validInput > number) {
                    System.out.printf("%d number is too high...", validInput);
                    high = validInput;
                    moves += 1;
                    continue;
                }

                if (validInput < number) {
                    System.out.printf("%d number is too low...", validInput);
                    low = validInput;
                    moves += 1;
                    continue;
                }
            } else if (input.equalsIgnoreCase("esc")) {                              // ΠΡΕΠΕΙ ΝΑ ΦΤΑΙΧΤΕΙ ΤΟ INPUT CASE
                System.out.println("Thank you for playing!!");
                break;
            } else {
                System.out.println("You didn't provide an arithmetic character, try again!");
                moves += 1;
            }

        }
    }

    public static boolean checkInt(String input) {
        boolean fact = false;
        try {
            int validinput = Integer.parseInt(input);
            fact = true;
        } catch (NumberFormatException error) {

        }
        return fact;
    }

    public static int getMax(ArrayList List) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < List.size(); i++) {
            if ((int) List.get(i) > max) {
                max = (int) List.get(i);
            }
        }
        return max;
    }

}
