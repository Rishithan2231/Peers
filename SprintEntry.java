 
public class SprintEntry extends Entry {

	private int howManyTimes;
	private int howLongBreak;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int ht, int lb) {
		super(n, d, m, y, h, min, s, dist);
		howManyTimes = ht;
		howLongBreak = lb;
	}

	public int getRepetitions() {
		return howManyTimes;
	}

	public int getRecovery() {
		return howLongBreak;
	}

	public String getEntry() {
		String result = getName() + " sprinted " + getRepetitions() + "X" + getDistance() + "m in " + getHour() + ":" + getMin() + ":" + getSec()
				+ " with " + getRecovery() + " minutes recovery on "  + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
		return result;
	} // getEntry

}