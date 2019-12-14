import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Abstract_Player implements Serializable{

	private static final long serialVersionUID = 1L;

	protected List<Character> guessedLetters = null;

	private String name=null;
	protected int tokens;
	private boolean inGame;
	
	Abstract_Player(String n, int t){
		name = n;
		tokens = t;
		inGame = true;
		guessedLetters = new ArrayList<Character>();
	}
	
	public void addTokens(int amt) {
		tokens+=amt;
	}
	public boolean rmTokens(int amt) {
		if (tokens>=amt){
			tokens-=amt;
			return true;
		}
		return false;
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
	
	public void setInGame(boolean b) {
		inGame = b;
	}
	public boolean getInGame() {
		return inGame;
	}
	
	public abstract String getGuess();
	
}
