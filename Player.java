
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
	public char getGuess() {
		System.out.println("You have 10 seconds to make a valid guess");
		
		long start = System.currentTimeMillis();

		while(true) {
			String guess = myObj.nextLine();
			
			if(System.currentTimeMillis()-start>10000) {
				System.out.println("You took to long and your turn expried");
				return 0;
			}
			if (guess.length()!=1) {
				System.out.println("Guess must be one letter");
			}else{
				if(guessedLetters.contains(guess.charAt(0))) {
					System.out.println("That letter has already been guessed");
				}else{
//					myObj.close();
					return guess.charAt(0);
				}			
			}
		}
	}

	
	
}
