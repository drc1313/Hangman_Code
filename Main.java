public class Main {

	public static void main(String args[]) {
		Controller c = new Controller();
		Save_Load sl = new Save_Load();
		
		Player p = sl.Load("Bob");

		c.addNewPlayer("Player1", true);
		
		c.addPlayer(p);

		c.addNewPlayer("bot", false);
		
		c.startGame();
	}
}
