import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
	Scanner myObj = new Scanner(System.in); 
	private List<Abstract_Player> playerList = new ArrayList<Abstract_Player>();
	private Man man = null;
	private char[] gameWord = null;
	private int gameWordSize=0;
	private List<Character> guessedLetters = null;
	private int count = 0;
	
	public void addNewPlayer(String name, boolean human) {
		if(human) {
			playerList.add(new Player("me",50));
		}else {
			playerList.add(new AI_Player("com",50));
		}
	}
	
	public void startGame() {
		if(playerList.size()>1) {
			man = new Man();
			setWord();
			guessedLetters=new ArrayList<Character>();
			while(!manStatus().equals("Right_Arm") && count!=gameWordSize) {
				for(Abstract_Player p : playerList) {
					
						displayWord();
						p.setLetters(guessedLetters);
						validateGuess(p.getGuess());
						if(manStatus().equals("Right_Arm") || count==gameWordSize) {
							break;
						}
					}
//				getGuess();
			}
			System.out.println("Game Is Over");
		}else {
			System.out.println(playerList.size());
			System.out.println("Not enough players");
		}
	}

	
	private void setWord() {
		
	    System.out.println("Enter Word");
	    String word = myObj.nextLine(); 
	    if(word.length()>0 && word.length()<=10) {
	    	gameWordSize = word.length();
	    	gameWord = word.toCharArray();
	    }else {
	    	System.out.println("Word must have 1-10 letters");
	    	setWord();
	    }
	}
	
//	private void getGuess() {
//		 
//	}
	
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
	
	public List<Character> getGuessed(){
		return guessedLetters;
	}

	
}
