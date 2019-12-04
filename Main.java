public class Main {
	
	public static void main(String args[]) {
		Controller c = new Controller();
		Save_Load sl = new Save_Load();
		sl.save(new Player("tim",50));

		//Adds player to game true means human false means AI bot		
		c.addPlayer(sl.Load("jim"));
		c.addPlayer(sl.Load("tim"));
		c.addNewPlayer("bot",false);
//		Player p = sl.Load("jim");
		
	
		c.startGame();		
	}
}
