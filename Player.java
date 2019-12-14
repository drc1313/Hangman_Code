
import java.util.Scanner;
import java.time.*;

public class Player extends Abstract_Player{

	private static final long serialVersionUID = 1L;
	private static Scanner myObj = new Scanner(System.in);
	
	Player(String n, int t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getGuess() {
		System.out.println("You have 15 seconds to make a valid guess. \n If you would like help enter 'help'");
		
		long start = System.currentTimeMillis();

		while(true) {
			String guess = myObj.nextLine();
			
			if(System.currentTimeMillis()-start>15000) {
				System.out.println("You took to long and your turn expried");
				return "0";
			}
			
			if (guess.length()!=1) {
				if(guess.contentEquals("help")) {
					System.out.println("------------------------------------------------------");
					System.out.println("1. You must enter one letter as a guess.");
					System.out.println("2. To guess word you can enter 'solve'. If wrong you will be removed from the game.");
					System.out.println("3. To reveal a letter enter in 'buy'. You must have at least 20 coins. You currently have "+ Integer.toString(tokens)+" tokens.");
					System.out.println("4. If you take too long to guess you will lose your turn and a part will be added.");
					System.out.println("5. The player who finishes the word will be awarded 25 coins.");
					System.out.println("6. If the word is not correctly guessed and the game ends the player who created the word gets 100 - amount of letters for entered word coins.");
					System.out.println("------------------------------------------------------");
					System.out.println("Enter Guess:");
				
				}else if(guess.contentEquals("solve")){
					System.out.println("Enter what you think the word is.");
					while(true) {
						guess = myObj.nextLine();
						if(guess.length()>1) {
							return guess;
						}
						System.out.println("Must be more than one letter.");
					}
					
				}else if(guess.contentEquals("buy")) {
					if(tokens>=25) {
						return "Buy";
					}else {
						System.out.println("You need 25 tokens to buy. You have "+Integer.toString(tokens));
					}
				}else {
					System.out.println("You entered too many letters.");
				}
			}else{
				if(guessedLetters.contains(guess.charAt(0))) {
					System.out.println("That letter has already been guessed");
				}else{
					return guess;
				}
			}
		}
	}

	
	
}
