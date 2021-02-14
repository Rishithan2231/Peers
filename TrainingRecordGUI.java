// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	//Setting the label
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JLabel labht = new JLabel(" Repetition Number:");
	private JLabel lablb = new JLabel(" Recovery Time:");
	private JLabel labbn = new JLabel(" Terrain:");
	private JLabel labt = new JLabel(" Tempo:");
	private JLabel labio = new JLabel(" Indoors or Outdoors:");
	
	//Setting the size of the labels
	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JTextField howManyTimes = new JTextField(4);
	private JTextField howLongBreak = new JTextField(2);
	private JTextField bikeName = new JTextField(25);
	private JTextField Tempo = new JTextField(4);
	private JTextField indoorsOrOutdoors = new JTextField(25);
	
	//The buttons for choosing what kind of data you want to input
	private JButton generalDataActivate = new JButton(" General Data ");
	private JButton sprintActivate = new JButton(" Sprint ");
	private JButton cycleActivate = new JButton(" Cycle ");
	private JButton swimActivate = new JButton(" Swim ");

	//The buttons for adding the inputs into a data format.
	private JButton addR = new JButton("Add General Data");
	private JButton Sprint = new JButton(" Add Sprint Data");
	private JButton Cycle = new JButton("Add Cycle Data");
	private JButton Swim = new JButton("Add Swim Data");
	
	//Query related buttons
	private JButton queries = new JButton("Queries");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton findAllByDate = new JButton("Find All");
	private JButton RemoveData = new JButton("Remove Data");



	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	public static void main(String[] args) {

		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	
	// set up the GUI
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		
		
		//Adding the different types of exercise and query related  buttons
		add(generalDataActivate);
		generalDataActivate.addActionListener(this);
		add(sprintActivate);
		sprintActivate.addActionListener(this);
		add(cycleActivate);
		cycleActivate.addActionListener(this);
		add(swimActivate);
		swimActivate.addActionListener(this);
		add(queries);
		queries.addActionListener(this);
		
		
		//Adding the labels for all types of queries.	
		add(labn);
		add(name);
		name.setEditable(false);
		add(labd);
		add(day);
		day.setEditable(false);
		add(labm);
		add(month);
		month.setEditable(false);
		add(laby);
		add(year);
		year.setEditable(false);
		add(labh);
		add(hours);
		hours.setEditable(false);
		add(labmm);
		add(mins);
		mins.setEditable(false);
		add(labs);
		add(secs);
		secs.setEditable(false);
		add(labdist);
		add(dist);
		dist.setEditable(false);
		
		//Adding the labels for sprinting 
		add(labht);
		add(howManyTimes);
		howManyTimes.setEditable(false);
		add(lablb);
		add(howLongBreak);
		howLongBreak.setEditable(false);
		
		//Adding the labels for cycling
		add(labbn);
		add(bikeName);
		bikeName.setEditable(false);
		add(labt);
		add(Tempo);
		Tempo.setEditable(false);
		
		//Adding the labels for swimming
		add(labio);
		add(indoorsOrOutdoors);
		indoorsOrOutdoors.setEditable(false);
		
		//Adduing the buttons that allows the type of query search
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(findAllByDate);
		findAllByDate.addActionListener(this);
		add(RemoveData);
		RemoveData.addActionListener(this);
		
		add(outputArea);
		setSize(850, 500);
		setVisible(true);
		blankDisplay();
		
		//Adding the buttons which would turn the input into a format
		add(addR);
		addR.addActionListener(this);
		add(Sprint);
		Sprint.addActionListener(this);
		add(Cycle);
		Cycle.addActionListener(this);
		add(Swim);
		Swim.addActionListener(this);
		
		//setEnabled for when the program is initially opened
		outputArea.setEditable(false);
		addR.setEnabled(false);
		lookUpByDate.setEnabled(false);
		findAllByDate.setEnabled(false);
		RemoveData.setEnabled(false);
		Swim.setEnabled(false);
		Sprint.setEnabled(false);
		Cycle.setEnabled(false);
		swimActivate.setEnabled(true);
		cycleActivate.setEnabled(true);
		sprintActivate.setEnabled(true);
		generalDataActivate.setEnabled(true);

	} // constructor

	// listen for and respond to GUI events
	public void actionPerformed(ActionEvent event) 
	{
		String message = "";
		
		
		//Listen for potential Generic Data.
		if (event.getSource() == addR) 
		{
			message = addEntry("generic");
		}
		
		if (event.getSource() == generalDataActivate )
		{
			name.setEditable(true);
			day.setEditable(true);
			month.setEditable(true);
			year.setEditable(true);
			hours.setEditable(true);
			mins.setEditable(true);
			secs.setEditable(true);
			dist.setEditable(true);
			howManyTimes.setEditable(false);
			howLongBreak.setEditable(false);
			bikeName.setEditable(false);
			Tempo.setEditable(false);
			indoorsOrOutdoors.setEditable(false); 
			addR.setEnabled(true);
			lookUpByDate.setEnabled(false);
			findAllByDate.setEnabled(false);
			RemoveData.setEnabled(false);
			Swim.setEnabled(false);
			Sprint.setEnabled(false);
			Cycle.setEnabled(false);
			swimActivate.setEnabled(true);
			cycleActivate.setEnabled(true);
			sprintActivate.setEnabled(true);
			generalDataActivate.setEnabled(true);

		}
		
		//Listen for potential swim related data.
		if (event.getSource() == swimActivate) 
		{
			name.setEditable(true);
			day.setEditable(true);
			month.setEditable(true);
			year.setEditable(true);
			hours.setEditable(true);
			mins.setEditable(true);
			secs.setEditable(true);
			dist.setEditable(true);
			howManyTimes.setEditable(false);
			howLongBreak.setEditable(false);
			bikeName.setEditable(false);
			Tempo.setEditable(false);
			indoorsOrOutdoors.setEditable(true); 
			addR.setEnabled(false);
			lookUpByDate.setEnabled(false);
			findAllByDate.setEnabled(false);
			RemoveData.setEnabled(false);
			Swim.setEnabled(true);
			Sprint.setEnabled(false);
			Cycle.setEnabled(false);
			swimActivate.setEnabled(true);
			cycleActivate.setEnabled(true);
			sprintActivate.setEnabled(true);
			generalDataActivate.setEnabled(true);

		}
		
		if (event.getSource() == Swim)
		{
			message = addEntry("Swim");

		}
		
		
		
		//Listen for potential cycling related data
		if (event.getSource() == cycleActivate) 
		{
			name.setEditable(true);
			day.setEditable(true);
			month.setEditable(true);
			year.setEditable(true);
			hours.setEditable(true);
			mins.setEditable(true);
			secs.setEditable(true);
			dist.setEditable(true);
			howManyTimes.setEditable(false);
			howLongBreak.setEditable(false);
			bikeName.setEditable(true);
			Tempo.setEditable(true);
			indoorsOrOutdoors.setEditable(false); 
			addR.setEnabled(false);
			lookUpByDate.setEnabled(false);
			findAllByDate.setEnabled(false);
			RemoveData.setEnabled(false);
			Swim.setEnabled(false);
			Sprint.setEnabled(false);
			Cycle.setEnabled(true);
			swimActivate.setEnabled(true);
			cycleActivate.setEnabled(true);
			sprintActivate.setEnabled(true);
			generalDataActivate.setEnabled(true);

		}
		
		if (event.getSource() == Cycle) 
		{
			message = addEntry("Cycle");

		}
		
		
		//Listen for potential Sprint related Data.
		if (event.getSource() == sprintActivate) 
		{
			name.setEditable(true);
			day.setEditable(true);
			month.setEditable(true);
			year.setEditable(true);
			hours.setEditable(true);
			mins.setEditable(true);
			secs.setEditable(true);
			dist.setEditable(true);
			howManyTimes.setEditable(true);
			howLongBreak.setEditable(true);
			bikeName.setEditable(false);
			Tempo.setEditable(false);
			indoorsOrOutdoors.setEditable(false); 
			addR.setEnabled(false);
			lookUpByDate.setEnabled(false);
			findAllByDate.setEnabled(false);
			RemoveData.setEnabled(false);
			Swim.setEnabled(false);
			Sprint.setEnabled(true);
			Cycle.setEnabled(false);
			swimActivate.setEnabled(true);
			cycleActivate.setEnabled(true);
			sprintActivate.setEnabled(true);
			generalDataActivate.setEnabled(true);
		}
		
		if (event.getSource() == Sprint) 
		{
			message = addEntry("Sprint");
		}
		
		//Listen for query related matters.
		
		if (event.getSource() == queries)
		{
			name.setEditable(true);
			day.setEditable(true);
			month.setEditable(true);
			year.setEditable(true);
			hours.setEditable(false);
			mins.setEditable(false);
			secs.setEditable(false);
			dist.setEditable(false);
			howManyTimes.setEditable(false);
			howLongBreak.setEditable(false);
			bikeName.setEditable(false);
			Tempo.setEditable(false);
			indoorsOrOutdoors.setEditable(false); 
			addR.setEnabled(false);
			lookUpByDate.setEnabled(true);
			findAllByDate.setEnabled(true);
			RemoveData.setEnabled(true);
			Swim.setEnabled(false);
			Sprint.setEnabled(false);
			Cycle.setEnabled(false);
			swimActivate.setEnabled(true);
			cycleActivate.setEnabled(true);
			sprintActivate.setEnabled(true);
			generalDataActivate.setEnabled(true);
		}
		
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		if (event.getSource() == findAllByDate) {
			message = lookupEntry();
		}
		if(event.getSource() == RemoveData) {
			message = deleteEntry();
		}

		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed
	
	

	public String addEntry(String what) 
	{	
		try 
		{
			if (what == "Swim") 
			{
				String n = name.getText();
				int m = Integer.parseInt(month.getText());
				int d = Integer.parseInt(day.getText());
				int y = Integer.parseInt(year.getText());
				int h = Integer.parseInt(hours.getText());
				int mm = Integer.parseInt(mins.getText());
				int s = Integer.parseInt(secs.getText());
				float km = java.lang.Float.parseFloat(dist.getText());
				String i = indoorsOrOutdoors.getText();
				Entry e = new SwimEntry(n, m, d, y, h, mm, s, km, i);
				System.out.println("Adding " + what + " entry to the records");
				String message = "Record added\n";
				myAthletes.addEntry(e);
				 return message;
			}
		}
		
		catch (Exception e)
		{
			System.out.println("Something is wrong.");
		}


		try 
		{
			if (what == "Sprint")
			{
				String n = name.getText();
				int m = Integer.parseInt(month.getText());
				int d = Integer.parseInt(day.getText());
				int y = Integer.parseInt(year.getText());
				int h = Integer.parseInt(hours.getText());
				int mm = Integer.parseInt(mins.getText());
				int s = Integer.parseInt(secs.getText());
				float km = java.lang.Float.parseFloat(dist.getText());
				int rep = Integer.parseInt(howManyTimes.getText());
				int rec = Integer.parseInt(howLongBreak.getText());
				Entry e = new SprintEntry(n, m, d, y, h, mm, s, km, rep, rec);
				System.out.println("Adding " + what + " entry to the records");
				String message = "Record added\n";
				myAthletes.addEntry(e);
				 return message;
			} 
		}

		catch (Exception e)
		{
			System.out.println("Something is wrong");
		}		



		try 
		{
			if (what == "Cycle")
			{
				String n = name.getText();
				int m = Integer.parseInt(month.getText());
				int d = Integer.parseInt(day.getText());
				int y = Integer.parseInt(year.getText());
				int h = Integer.parseInt(hours.getText());
				int mm = Integer.parseInt(mins.getText());
				int s = Integer.parseInt(secs.getText());
				float km = java.lang.Float.parseFloat(dist.getText());
				String bn = bikeName.getText();
				String t = Tempo.getText();
				Entry e = new CycleEntry(n, m, d, y, h, mm, s, km, bn, t);
				System.out.println("Adding " + what + " entry to the records");
				String message = "Record added\n";
				myAthletes.addEntry(e);
				 return message;

			}
		}
		
		catch (Exception e)
		{
			System.out.println("Something is wrong");
		}	

	
		try 
		{
			if (what != "Cycle" && what != "Swim" && what != "Sprint" )
			{
				String n = name.getText();
				int m = Integer.parseInt(month.getText());
				int d = Integer.parseInt(day.getText());
				int y = Integer.parseInt(year.getText());
				float km = java.lang.Float.parseFloat(dist.getText());
				int h = Integer.parseInt(hours.getText());
				int mm = Integer.parseInt(mins.getText());
				int s = Integer.parseInt(secs.getText());
				Entry e = new Entry(n, d, m, y, h, mm, s, km);
				System.out.println("Adding " + what + " entry to the records");
				String message = "Record added\n";
				myAthletes.addEntry(e);
				 return message;
			}

		}
		
		catch (Exception e)
		{
			System.out.println("Something is wrong");
		}
		
		return "Something is wrong";

	}

	public String lookupEntry() 
	{
		try {
			int m = Integer.parseInt(month.getText());
			int d = Integer.parseInt(day.getText());
			int y = Integer.parseInt(year.getText());
			outputArea.setText("looking up record ...");
			String message = myAthletes.lookupEntry(d, m, y);
			return message;
		}
		catch (Exception e)
		{
			String message = "Something is wrong";
			return message;
		}
		
	}


	public String deleteEntry() {
		try {
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("Delete Record");
		String message = myAthletes.deleteEntry(n, d, m, y);
		return message;
		}
		catch (Exception e)
		{
			String message = "Something is wrong";
			return message;
		}
	}   


	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
		indoorsOrOutdoors.setText("");
		bikeName.setText("");
		Tempo.setText("");
		howManyTimes.setText("");
		howLongBreak.setText("");

	}// blankDisplay
	// Fills the input fields on the display for testing purposes only

	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}


} // TrainingRecordGUI
