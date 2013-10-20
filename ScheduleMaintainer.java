import java.util.ArrayList;
import java.util.LinkedList;


public class ScheduleMaintainer {
	
	public static void addJobHistory(ArrayList<Person> allTheRoommates) {
		
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
	
	public static void printCurrentSchedule(ArrayList<Person> allTheRoommates) {
		
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
	
	public static void printThisWeekSchedule(ArrayList<Person> allTheRoommates) {
		
		String currentJob = "";
		for (int i = 0; i < allTheRoommates.size(); i++) {
	
		currentJob = allTheRoommates.
				get(i).getJobArray().get(
						allTheRoommates.get(i).getJobArray().size()-1);
		System.out.println(allTheRoommates.get(i).getName() + ": " + currentJob);
			
		}
		
	}

}
