import java.util.Random;
public class AI_Player extends Abstract_Player{

	private static final long serialVersionUID = 1L;
	private char[] letters= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	AI_Player(String n, int t) {
		super(n, t);
	}

	@Override
	public String getGuess() {
		Random r = new Random();
		while(true) {			
			String guess = Character.toString(letters[r.nextInt(letters.length)]);
			if(!guessedLetters.contains(guess.charAt(0))) {
				long start = System.currentTimeMillis();
				while(System.currentTimeMillis()-start<2000) {
					//Do Nothing
				}
				System.out.println(guess);
				return guess;
			}		
		}
	}
	
}
