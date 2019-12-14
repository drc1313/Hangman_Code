import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
	Scanner myObj = new Scanner(System.in); 
	private List<Abstract_Player> playerList = new ArrayList<Abstract_Player>();
	private int outPlayers=1;
	private Man man = null;
	private char[] gameWord = null;
	private int gameWordSize=0;
	private List<Character> guessedLetters = null;
	private int count = 0;
	private boolean winner = false;
	private Save_Load sl= new Save_Load();
	
	public void addNewPlayer(String name, boolean human) {
		if(human) {
			playerList.add(new Player(name, 25));
		}else {
			playerList.add(new AI_Player(name, 0));
		}
	}
	public void addPlayer(Player p) {
		p.setInGame(true);
		playerList.add(p);
		
	}
	public void startGame() {
		if(playerList.size()>1) {
			man = new Man();
			int playerSize = playerList.size();
			Abstract_Player curPlayer = null;
			setWord();
			guessedLetters=new ArrayList<Character>();
			while(!manStatus().equals("Right_Arm") && winner == false && playerSize-outPlayers != 0) {
				for(int i=0;i<playerList.size();i++) {					
					Abstract_Player p = playerList.get(i);
					if(p.getInGame()==true) {
						curPlayer = p;
						delay();
						System.out.println("\n ----------------------------------------");
						displayWord();
						p.setLetters(guessedLetters);
						System.out.println("");
						System.out.println(p.getName()+" Enter Guess:");
						if(validateGuess(p)) {
							i-=1;
						}
						if(manStatus().equals("Right_Arm") || winner == true) {
							break;
						}
					}					
				}
			}
			String word = new String(gameWord);
			if(winner == true) {
				curPlayer.addTokens(25);
				System.out.println(curPlayer.getName()+ " Wins and got 25 coins. '"+word+ "' was the correct word");	
				savePlayers();
			}else {
				playerList.get(0).addTokens(100-(gameWordSize*10));
				System.out.println("The man is hung. '"+word+"' was the correct word. "+playerList.get(0).getName()+" wins and got "+Integer.toString(100-(gameWordSize*10))+" Tokens. \n You now have "+playerList.get(0).getTokens()+" tokens." );
				savePlayers();
			}
		}else {
			System.out.println(playerList.size());
			System.out.println("Not enough players");
		}
	}

	
	private void setWord() {
		String word = null;
		Player p = (Player) playerList.get(0);
		p.setInGame(false);
		while(true) {
			
		    System.out.println(p.getName()+": Enter Word");
		    word = myObj.nextLine();
		    if(word.contains(" ") || word.length()<=1 || word.length()>=11) {
		    	System.out.println("Cannot have spaces and must have 1-10 letters");
		    }else {
		    	break;
		    }
		}
		word = word.toLowerCase();
		gameWordSize = word.length();
    	gameWord = word.toCharArray();
	}
	

	
	private boolean validateGuess(Abstract_Player p) {
		String g = p.getGuess();
		if(g=="0") {
			// Means time ran out
			return false;
		}
		if(g=="Buy") {			
			return buyLetter(p);
		}
		if(g.length()>1) {
			solveWord(p, g);
			return false;
		}		
		guessedLetters.add(g.charAt(0));
		for(char c : gameWord) {
			if(c==g.charAt(0)) {
				System.out.println("");
				System.out.println("Correct! You get another turn!");
				checkWin();
				return true;
			}
		}
		
		man.addPart();
		System.out.println("Incorrect. The "+man.getStatus()+" has been added.");
		return false;
		
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
		if(count == gameWordSize) {
			winner = true;
		}
	}
	
	public List<Character> getGuessed(){
		return guessedLetters;
	}
	
	public void delay(){
		long start = System.currentTimeMillis();
		while(System.currentTimeMillis()-start<1500) {
			//Do Nothing
		}
	}
	
	public boolean buyLetter(Abstract_Player p) {
		if(p.rmTokens(20)) {
			sl.save((Player) p);
			for(char c:gameWord) {
				if(!guessedLetters.contains(c)) {
					guessedLetters.add(c);
					System.out.println(p.getName()+" has bought a letter and "+ c +" has been added.");
					System.out.println(p.getName() + " now has "+p.getTokens()+" left.");
					System.out.println(p.getName()+"You may take another turn.");
					checkWin();
					return true;
				}
			}
		}
		return false;
	}
	
	public void solveWord(Abstract_Player p, String g) {
		String word = new String(gameWord);
		if(word.contentEquals(g)) {
			winner = true;
		}else {
			System.out.println("Incorrect! "+p.getName()+" has been removed from the game.");
			p.setInGame(false);
			outPlayers++;
			delay();
		}
		
	}
	
	private void savePlayers() {
		
		for(Abstract_Player p:playerList) {
			if(p.getClass().toString().contains("class Player")) {
				sl.save((Player)p);
			}
		}
	}
	
	
	

	
}
