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
	
	public static void main(String[] args) {
		
		allTheRoommates = new ArrayList<Person>();
		// try to de-serialize
		allTheRoommates = StructureIO.deserializeRoommates(allTheRoommates);
		// print out current schedule
		ScheduleMaintainer.printCurrentSchedule(allTheRoommates);
		// ask if the user wants next week's schedule
		askForInput();
		// print out next week's schedule
		ScheduleMaintainer.printThisWeekSchedule(allTheRoommates);
		// save and exit
		StructureIO.serializeRoommates(allTheRoommates);
		
	}
	
	public static ArrayList<Person> initRoommates() {
		
		// if (FileNotFoundException) initiate the objects
		Person a = new Person("Jemmy", true);
		Person b = new Person("Chase", true);
		Person c = new Person("Paul", false);
		Person d = new Person("Peter", false);
							
		allTheRoommates.add(a);
		allTheRoommates.add(b);
		allTheRoommates.add(c);
		allTheRoommates.add(d);
		
		StructureIO.serializeRoommates(allTheRoommates);
		
		return allTheRoommates;
		
	}

	private static void askForInput() {
		
		String input;
		
		@SuppressWarnings("resource")
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
	
}
