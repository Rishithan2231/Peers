// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

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

	private JButton addR = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton FindAllByDate = new JButton("Find All");
	private JButton RemoveData = new JButton("Remove Data");

	private JButton Sprint = new JButton("Sprint");
	private JButton Cycle = new JButton("Cycle");
	private JButton Swim = new JButton("Swim");

	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	public static void main(String[] args) {

		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	// set up the GUI
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);

		add(labht);
		add(howManyTimes);
		howManyTimes.setEditable(true);

		add(lablb);
		add(howLongBreak);
		howLongBreak.setEditable(true);

		add(labbn);
		add(bikeName);
		bikeName.setEditable(true);

		add(labt);
		add(Tempo);
		Tempo.setEditable(true);

		add(labio);
		add(indoorsOrOutdoors);
		indoorsOrOutdoors.setEditable(true);

		add(addR);
		addR.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(FindAllByDate);
		FindAllByDate.addActionListener(this);
		add(RemoveData);
		RemoveData.addActionListener(this);

		add(Sprint);
		Sprint.addActionListener(this);

		add(Cycle);
		Cycle.addActionListener(this);

		add(Swim);
		Swim.addActionListener(this);

		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();

		// To save typing in new entries while testing, uncomment
		// the following lines (or add your own test cases)

	} // constructor

	// listen for and respond to GUI events
	public void actionPerformed(ActionEvent event) {
		String message = "";
		if (event.getSource() == addR) {
			message = addEntry("generic");
		}
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		if (event.getSource() == FindAllByDate) {
			message = lookupEntry();
		}
		if(event.getSource() == RemoveData) {
			message = deleteEntry();
		}
		if (event.getSource() == Swim) {
			message = addEntry("Swim");
		}
		if (event.getSource() == Cycle) {
			message = addEntry("Cycle");
		}
		if (event.getSource() == Sprint) {
			message = addEntry("Sprint");
		}
		

		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed

	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		if (what == "Swim") {
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
			myAthletes.addEntry(e);

		} else if (what == "Sprint"){
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
			myAthletes.addEntry(e);	
		} 
		else if (what == "Cycle"){
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
			myAthletes.addEntry(e);	
			
		}
		else
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
			myAthletes.addEntry(e);
		}

		return message;
	}

	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}
	
	
	 public String deleteEntry() {
		 String n = name.getText();
			int m = Integer.parseInt(month.getText());
			int d = Integer.parseInt(day.getText());
			int y = Integer.parseInt(year.getText());
			outputArea.setText("Delete Record");
			String message = myAthletes.deleteEntry(n, d, m, y);
			return message;
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
