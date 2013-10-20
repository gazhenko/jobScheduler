import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class StructureIO {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Person> deserializeRoommates(ArrayList<Person> allTheRoommates) {
		
		try {
					
			FileInputStream fileIn = 
					new FileInputStream("/home/jim/Dropbox/roommateData.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			allTheRoommates = (ArrayList<Person>) in.readObject();
			in.close();
			fileIn.close();
			
			return allTheRoommates;
					
		}
		catch (FileNotFoundException e) {
					
			System.out.println("UHOH no file!");
			
			
			allTheRoommates = MainCleanUpSchedule.initRoommates();
					
			ScheduleMaintainer.addJobHistory(allTheRoommates);
			
			return allTheRoommates;
					
		}
		catch (IOException e) {
					
			e.printStackTrace();
			return null;
					
		}
		catch (ClassNotFoundException e) {
					
			e.printStackTrace();
			return null;
					
		}
				
	}

	public static void serializeRoommates(ArrayList<Person> allTheRoommates) {

		try {
					
			FileOutputStream fileOut = 
					new FileOutputStream("/home/jim/Dropbox/roommateData.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allTheRoommates);
			out.close();
			fileOut.close();
					
		}
		catch(IOException e) {
					
			System.out.println("NOOO Can't write here!!");
			e.printStackTrace();
					
		}
				
	}
	
}
