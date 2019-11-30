import java.util.Scanner;

public class Player extends Abstract_Player{
	
	Player(String n, int t) {
		super(n, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getGuess() {
		Scanner myObj = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Guess:");
			String guess = myObj.nextLine();
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
