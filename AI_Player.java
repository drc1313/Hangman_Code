//import java.util.List;
import java.util.Random;
public class AI_Player extends Abstract_Player{

	private char[] letters= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//	private List<Character> guessedLetters = null;
	
	AI_Player(String n, int t) {
		super(n, t);
	}

	@Override
	public char getGuess() {
		Random r = new Random();
		while(true) {
			
			char guess = letters[r.nextInt(letters.length)];
			if(!guessedLetters.contains(guess)) {
				System.out.println(guess);
				return guess;
			}		
		}
	}
	
}
