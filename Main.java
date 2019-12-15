public class Main {

	public static void main(String args[]) {
		Controller c = new Controller();
		Save_Load sl = new Save_Load();
	
		c.addNewPlayer("Sam", true);
		c.addNewPlayer("Pam", true);
		c.addPlayer(sl.Load("Bob"));

		
//		c.addNewPlayer("bot", false);
		
		c.startGame();
	}
}
