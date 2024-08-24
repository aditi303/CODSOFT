import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        // Main game loop
        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;  // Generate a random number between 1 and 100
            int attemptsLeft = 10;  // Set maximum attempts to 10
            boolean hasWon = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100. You have " + attemptsLeft + " attempts.");

            // Round loop
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    hasWon = true;
                    score += attemptsLeft;  // Add remaining attempts to score
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!hasWon) {
                System.out.println("Sorry, you have run out of attempts. The correct number was " + randomNumber);
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();

            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
