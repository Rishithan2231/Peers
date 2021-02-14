 
public class SprintEntry extends Entry {

	private int howManyTimes;
	private int howLongBreak;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int ht, int lb) {
		super(n, d, m, y, h, min, s, dist);
		howManyTimes = ht;
		howLongBreak = lb;
	}

	//Gets how many times running has been repeated.
	public int getRepetitions() {
		return howManyTimes;
	}

	//Gets how long the recovery period is.
	public int getRecovery() {
		return howLongBreak;
	}

	public String getEntry() {
		String result = getName() + " sprinted " + getRepetitions() + "x" + getDistance() + "m in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " with " + getRecovery() + " minutes recovery on "  + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		return result;
	} // getEntry

}