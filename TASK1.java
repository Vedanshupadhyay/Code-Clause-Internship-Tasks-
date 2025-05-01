
// random number game

import java.util.*;

public class TASK1 {

    public static void main(String[] args) {
        boolean playagain = true;
        while (playagain) {
            Random rand = new Random();
            int randomNum = rand.nextInt(100) + 1;
            // System.out.println("your random no. is : "+randomNum);

            Scanner sc = new Scanner(System.in);
            int guessNum = 0;
            int attempts = 0;
            int maxattempts = 5;
            int Total_Rounds = 0;
            int rounds_won = 0;
            // System.out.println("Please enter a number between 1 and 100");
            // int guessNum = sc.nextInt();

            // while (randomNum != guessNum)
            do

            {
                System.out.println("Please enter a number between 1 and 100");
                guessNum = sc.nextInt();
                attempts++;

                if (guessNum < randomNum) {
                    System.out.println("Your number is too low");
                } else if (guessNum > randomNum) {
                    System.out.println("Your number is too high");
                } else {
                    System.out.println("Your number is correct");
                    break;
                }

            } while (guessNum != randomNum && attempts <= maxattempts);
            if (guessNum != randomNum)

            {
                System.out.println("You ve used all the attempts the correct number : " + randomNum);
            }
            System.out.println("your result  ");

            Total_Rounds++;
            if (guessNum == randomNum) {
                System.out.println("Congratulations! You have won the game");
                rounds_won++;
            }
            System.out.println("rounds played : " + Total_Rounds);
            System.out.println("Rounds won : " + rounds_won);

            System.out.println("do you want to play again? (y/n)");
            sc.nextLine();
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing again");
                playagain = true;
            } else if (answer.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing");
                playagain = false;
            } else {
                System.out.println("Sorry, that is not valid");
                playagain = false;
            }
        }
    }
}