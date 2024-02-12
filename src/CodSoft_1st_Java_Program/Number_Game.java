package CodSoft_1st_Java_Program;

import java.util.Random;
import java.util.Scanner;

public class Number_Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 Random random = new Random();
		 
		 int lowerBound = 1;
		 int upperBound = 100;
		 int attemptsLimit = 10;
		 int rounds = 0;
		 int score = 0;
		 
		 System.out.println("Welcome to the Number Guessing Game!");
		 
		 do {
			int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
			int attempts = 0;
			boolean guessedCorrectly = false;
			
			System.out.println("\nRound"+(rounds + 1));
			System.out.println("Guess the number between"+ lowerBound +"and"+ upperBound);
			
		 while (attempts < attemptsLimit)
		 {
			 System.out.println("Enter your guess:");
			 int userGuess = sc.nextInt();
			 
			 if (userGuess == targetNumber) {
				guessedCorrectly = true;
				
				System.out.println("Congratulations! You guessed the correct number.");
				break;
			 }else if (userGuess < targetNumber) {
				 System.out.println("Too low. Try again.");
			 }else {
				System.out.println("Too high. Try again.");
			}
			attempts++;
		 }
		 if(!guessedCorrectly) {
			 System.out.println("Sorry, you've reached the maximum number of attempts. The correct numbner was: " + targetNumber);
		} else {
			score += attemptsLimit - attempts;
		}
		 
		 System.out.println("Your current score: " + score);		
		 System.out.println("Do you want to play again?(yes/no):");
		 String playAgain = sc.next();
		 
		 if("no".equalsIgnoreCase(playAgain)) {
			break;
		}
		rounds++;
		
		 }while(true);
		 System.out.println("Thanks for playing! Your final score:"+score);
		 
		 sc.close();
	}

}
