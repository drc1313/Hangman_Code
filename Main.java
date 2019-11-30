public class Main {
	
	public static void main(String args[]) {
		Controller c = new Controller();
		c.addNewPlayer("jim", true);
		c.addNewPlayer("tim", false);
		c.startGame();
	}	
}
