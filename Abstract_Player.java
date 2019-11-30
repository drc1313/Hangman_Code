import java.util.ArrayList;
import java.util.List;

public abstract class Abstract_Player {
	protected List<Character> guessedLetters = null;

	String name=null;
	int tokens;
	Abstract_Player(String n, int t){
		name = n;
		tokens = t;
		guessedLetters = new ArrayList<Character>();
	}
	
	public void addTokens(int amt) {
		tokens+=amt;
	}
	public void rmTokens(int amt) {
		if (tokens>=amt){
			tokens-=amt;
		}
	}
	public int getTokens() {
		return tokens;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name=n;
	}
	
	public void addLetter(char c) {
		guessedLetters.add(c);
	}
	
	public void clearLetters() {
		guessedLetters.clear();
	}
	
	public void setLetters(List<Character> l) {
		guessedLetters=l;
	}
	
	public abstract char getGuess();
	
}
