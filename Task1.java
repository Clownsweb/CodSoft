import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guess = false;
            
            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int PlayerGuess = scanner.nextInt();
                attempts++;

                if (PlayerGuess == numberGuess) {
                    System.out.println("Bravo! You guessed the correct number in " + attempts + " attempts.");
                    guess = true;
                    score++;
                    break;
                } else if (PlayerGuess < numberGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guess) {
                System.out.println("Sorry, you've exempted the max attempts,Better Luck Next Time. The correct number was: " + numberGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("Your total score is: " + score);
        scanner.close();
    }
}
