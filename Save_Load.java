import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Save_Load {
	private List<Player> playerList;
	private Man man = null;
	
	public void save(Player p) {
		
		try {
			File file = new File("Players.txt");
			
			if(!file.createNewFile()) {
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				playerList = (ArrayList<Player>) oi.readObject();
				if(playerList == null) {
					playerList = new ArrayList<Player>();
				}
				oi.close();
				fi.close();
			}else {
				playerList = new ArrayList<Player>();
			}
			
			
			
			boolean exists = false;
			for(Player pl: playerList) {
				if(pl.getName().contentEquals(p.getName())) {
					playerList.remove(pl);
					playerList.add(p);
					exists = true;
					break;
				}
			}
			if(!exists) {
				playerList.add(p);
				System.out.println("foudnd");

			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileOutputStream f = new FileOutputStream(new File("Players.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(playerList);
			
			o.close();
			f.close();

			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		

	}

	public Player Load(String playerName) {

		try {
			FileInputStream fi = new FileInputStream(new File("Players.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			playerList = (ArrayList<Player>) oi.readObject();

			oi.close();
			fi.close();
			for(Player p:playerList) {
				if(p.getName().contentEquals(playerName)) {
					return p;
				}
			}
			return null;			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	

