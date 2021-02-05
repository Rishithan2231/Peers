
public class SwimEntry extends Entry 
{
	private String indoorsOrOutdoors;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String io) {
		super(n, d, m, y, h, min, s, dist);
	
		indoorsOrOutdoors = io;
		

	}
	
	  public String getWhere () 
	  {
		  String where = null;
		  if (indoorsOrOutdoors == "pool")
		  {
			  where = "in a pool";		  
			  return where;

		  }
		    
		  else  if (indoorsOrOutdoors == "outdoors")
		  {
			  where = "outdoors";
			  return where;

		  }
		  return where;		  
	  }
	  
	  public String getEntry() 
		{
			String result = getName() + " swam " + getDistance() + " km " + getWhere() +  " in " + getHour() + ":" + getMin() + ":" + getSec()
					+ " on " + getDay() + "/" + getMonth() + "/" + getYear();
			return result;
		} // getEntry
	  
	  

	  
}
