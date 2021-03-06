// An implementation of a Training Record as an ArrayList

import java.util.*;

public class TrainingRecord {
	private List<Entry> tr;

	public TrainingRecord() {
		tr = new ArrayList<Entry>();

	} // constructor

	// add a record to the list
	public void addEntry(Entry e) {
		tr.add(e);
	} // addClass

	// look up the entry of a given day, month and year
	public String lookupEntry(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		StringBuilder result = new StringBuilder("");
		while (iter.hasNext()) 
		{
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
			{
				result.append(current.getEntry() + " ");

			}
			
			else
			{
				result.append("Something is wrong.");

			}
		}

		
		return result.toString();
	} // lookupEntry

	// Count the number of entries
	public int getNumberOfEntries() {
		return tr.size();
	}

	// Clear all entries
	public void clearAllEntries() {
		tr.clear();
	}
	
	 public void removeEntryIndex(int index){
	       tr.remove(index);
	   }
	   

	// Delete Entry
	public String deleteEntry(String n, int d, int m, int y) {
		 ListIterator<Entry> iter = tr.listIterator();
	       int index = -1;
	       String result = "Entry not found";
	       while (iter.hasNext()) {
	          index ++;
	          Entry current = iter.next();
	          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n)){
	             removeEntryIndex(index);
	             System.out.println("Entry removed");
	             result = "Entry removed";
	          }             
	             
	            }
	       return result;

	}
}// TrainingRecord