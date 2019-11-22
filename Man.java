
public class Man {
	public int pos=0;
	enum Man_Status 
	{ 
	    Nothing, Head, Torso, Left_Leg, Right_Leg, Left_Arm, Right_Arm; 
	}
	public void addPart() {
		pos+=1;
	}
	public String getStatus() {
		return Man_Status.values()[pos].toString();
	}
}
