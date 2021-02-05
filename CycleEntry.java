
public class CycleEntry extends Entry {
	private String bikeName;
	private String Tempo;

	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String bn, String t) {
		super(n, d, m, y, h, min, s, dist);
		bikeName = bn;
		Tempo = t;
	}

	public String getTerrain() 
	{
		return bikeName;
	}// getTerrain

	public String getTempo() 
	{
		return Tempo;
	}// getTerrain

	public String getEntry() 
	{
		String result = getName() + " cycled " + getDistance() + " km in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " on " + getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " + getTempo()
				+ " tempo";
		return result;
	} // getEntry

}
