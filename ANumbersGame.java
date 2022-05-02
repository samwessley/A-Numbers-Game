import java.util.Scanner;

public class ANumbersGame {

    int max = 50;
    int secretNumber;
    int numberOfGuesses = 0;
    
    public static void main(String[] args) {
        ANumbersGame aNumbersGame = new ANumbersGame();
        aNumbersGame.playGame();
    }

    public void playGame() {
        boolean difficultyLevelSet = false;
        Scanner scanner = new Scanner(System.in);
        int difficultyLevel = 0;

        // Prompt the player to enter their difficulty level. Keep asking them until they give a valid answer.
        while (difficultyLevelSet == false) {
            System.out.print("Enter your difficulty level -> 1 for easy, 2 for medium, or 3 for hard: ");
            difficultyLevel = scanner.nextInt();

            if (difficultyLevel == 1 || difficultyLevel == 2 || difficultyLevel == 3) {
                secretNumber = (int)(Math.random() * max);
                difficultyLevelSet = true;
            } else {
                System.out.println("That's not an option! Try again.");
            }
        }

        // Adjust the maximum value according to the player's selected difficulty
        if (difficultyLevel == 2) {
            max = 500;
        } else if (difficultyLevel == 3) {
            max = 1000;
        }

        System.out.println();
        System.out.println("Ok. I'm thinking of a number between 1 and " + max + ".");
        System.out.println("Enter a guess and I'll tell you if the secret number is higher or lower than your guess.");
        System.out.print("What's your guess? : ");

        // Keep asking the player to guess a new number until they guess correctly, then exit the program.
        while(true) {
            scanner = new Scanner(System.in);
            int guess = scanner.nextInt();

            if (guess < secretNumber) {
                System.out.println("Nope. It's higher. Guess again:");
                numberOfGuesses++;
            } else if (guess > secretNumber) {
                System.out.println("Wrong! It's lower. Guess again:");
                numberOfGuesses++;
            } else {
                System.out.print("That's right! You guessed the number in " + numberOfGuesses + " guesses.");
                
                if (numberOfGuesses < 5) {
                    System.out.println(" Great job!");
                } else if (numberOfGuesses >= 5 && numberOfGuesses < 10) {
                    System.out.println(" You did ok.");
                } else {
                    System.out.println(" This isn't your skill.");
                }
                scanner.close();
                System.exit(0);
            }
        }
    }

}