import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class MainCleanUpSchedule {

	//local variables
	private static ArrayList<Person> allTheRoommates;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// try to deserialize
		allTheRoommates = new ArrayList<Person>();
		try {
			
			FileInputStream fileIn = 
					new FileInputStream("/home/jim/Dropbox/roommateData.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			allTheRoommates = (ArrayList<Person>) in.readObject();
			in.close();
			fileIn.close();
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("UHOH no file!");
			// if (FileNotFoundException) initiate the objects
			Person a = new Person("Jemmy", true);
			Person b = new Person("Chase", true);
			Person c = new Person("Paul", false);
			Person d = new Person("Peter", false);
			
			allTheRoommates.add(a);
			allTheRoommates.add(b);
			allTheRoommates.add(c);
			allTheRoommates.add(d);
			
			addJobHistory();
			
			serializeRoommates();
			
		}
		catch (IOException e) {
			
			System.out.println("blah");
			e.printStackTrace();
			return;
			
		}
		catch (ClassNotFoundException e) {
			
			System.out.println("blah");
			e.printStackTrace();
			return;
			
		}
		// print out current schedule
		printCurrentSchedule();
		// ask if the user wants next week's schedule
		askForInput();
		// print out next week's schedule
		printThisWeekSchedule();
		// save and exit
		serializeRoommates();
		
	}

	private static void serializeRoommates() {

		try {
			
			FileOutputStream fileOut = 
					new FileOutputStream("/home/jim/Dropbox/roommateData.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allTheRoommates);
			out.close();
			fileOut.close();
			System.out.println("SAVED");
			
		}
		catch(IOException e) {
			
			System.out.println("NOOO Can't write here!!");
			e.printStackTrace();
			
		}
		
	}
	
	private static void printCurrentSchedule() {
		
		LinkedList<String> currentSchedule;
		String printOut = "";
		for (int i = 0; i < allTheRoommates.size(); i++) {
			
				currentSchedule = allTheRoommates.get(i).getJobArray();
				for (int j = 0; j < currentSchedule.size(); j++) {
					
					printOut += " Week " + j + ": " + currentSchedule.get(j);
					
				}
				System.out.println(allTheRoommates.get(i).getName()
						+ ": " + printOut);
				printOut = "";
				
		}
		
	}
	
	private static void printThisWeekSchedule() {
		
		String currentJob = "";
		for (int i = 0; i < allTheRoommates.size(); i++) {
	
			currentJob = allTheRoommates.
					get(i).getJobArray().get(
							allTheRoommates.get(i).getJobArray().size()-1);
			System.out.println(allTheRoommates.get(i).getName() + ": " + currentJob);
			
		}
		
	}
	
	private static void askForInput() {
		
		String input;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to see next week's schedule? (Y/n)");
		input = in.nextLine();
		if (input.equals("Y")) {
			
			String nextJob;
			Person current;
			for (int i = 0; i < allTheRoommates.size(); i++) {
				
				current = allTheRoommates.get(i);
				nextJob = JobAssigner.assign(current);
				current.setJob(nextJob);
			
			}
				
		}
		
	}
	
	private static void addJobHistory() {
		
		Person current;
		current = allTheRoommates.get(0);
		current.setJob("dishes");
		current.setJob("bathroom");
		current.setJob("dishes");
		
		current = allTheRoommates.get(1);
		current.setJob("livingroom");
		current.setJob("dishes");
		current.setJob("kitchen");
		
		current = allTheRoommates.get(2);
		current.setJob("bathroom");
		current.setJob("kitchen");
		current.setJob("livingroom");
		
		current = allTheRoommates.get(3);
		current.setJob("kitchen");
		current.setJob("livingroom");
		current.setJob("bathroom");
		
	}
	
}
