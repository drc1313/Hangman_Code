import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
	Scanner myObj = new Scanner(System.in); 
	private List<Player> playerList = new ArrayList<Player>();
	private Man man = null;
	private char[] gameWord = null;
	private int gameWordSize=0;
	private List<Character> guessedLetters = null;
	private int count = 0;
	
	public void addNewPlayer(String name) {
		playerList.add(new Player(name,50));
	}
	
	public void startGame() {
		if(playerList.size()>1) {
			man = new Man();
			setWord();
			guessedLetters=new ArrayList<Character>();
			while(!manStatus().equals("Right_Arm") && count!=gameWordSize) {
				getGuess();
			}
			System.out.println("Game Is Over");
		}else {
			System.out.println("Not enough players");
		}
	}
	
	private void setWord() {
		
	    System.out.println("Enter Word");
	    String word = myObj.nextLine(); 
	    gameWordSize = word.length();
	    gameWord = word.toCharArray();
	}
	
	private void getGuess() {
		 System.out.println(count);
		 displayWord();
		 System.out.println("Enter Guess:");
		 String guess = myObj.nextLine(); 
		 if (guess.length()!=1) {			 
			 System.out.println("Guess must be one letter");
			 getGuess();
		 }else {
			 if(!guessedLetters.contains(guess.charAt(0))) {
				 validateGuess(guess.charAt(0));
			 }else {
				 System.out.println("That letter has already been guessed");
			 }
		 }
	}
	
	private void validateGuess(char g) {		
		guessedLetters.add(g);
		for(char c : gameWord) {
			if(c==g) {
				System.out.println("Correct");
				checkWin();
				return;
			}
		}
		System.out.println("Incorrect. Adding Part");
		man.addPart();
	}
	
	public String manStatus() {
		return man.getStatus();
	}
	
	private void displayWord() {
		
		for(char c : gameWord) {
			if(guessedLetters.contains(c)) {
				System.out.print(c+" ");
				
			}else {
				System.out.print("_ ");
			}
		}
		System.out.print('\n');
	}
	
	private void checkWin() {
		count=0;
		for(char c : gameWord) {
			if(guessedLetters.contains(c)) {				
				count++;
			}
		}
	}
	

	
}
