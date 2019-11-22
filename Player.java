
public class Player {
	private String name;
	private int tokens;
	
	Player(String n, int t){
		name = n;
		tokens = t;
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
}
