
public class SwimEntry extends Entry 
{
	private String indoorsOrOutdoors;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String io) {
		super(n, d, m, y, h, min, s, dist);
	
		indoorsOrOutdoors = io;
		

	}

	//Tries figuring whether the swimming took place indoors or outdoors. 	
	  public String getWhere() 
	  {
		  if (indoorsOrOutdoors.equals("pool") )
		  {
			  return "in a pool";

		  }
		    
		  else  if (indoorsOrOutdoors.equals("outdoors") )
		  {
			 
			  return "outdoors";

		  }
		  else
		  {
			  return "where";

		  }
	  }
	  
	  public String getEntry() 
		{
			String result = getName() + " swam " + getDistance() + " km " + getWhere() +  " in " + getHour() + ":" + getMin() + ":" + getSec()
					+ " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
			return result;
		} // getEntry
	  
	  

	  
}
