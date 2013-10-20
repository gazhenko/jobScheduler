import java.util.LinkedList;


public class Person implements java.io.Serializable {

	// local variables
	private String name;
	private boolean dishes;
	private LinkedList<String> jobArray;
	
	
	public Person(String name, boolean dishes) {
		
		this.name = name;
		this. dishes = dishes;
		jobArray = new LinkedList<String>();
		
	}
	
	public void setJob(String nextJob) {
		
		this.jobArray.add(nextJob);
		
	}
	
	public LinkedList<String> getJobArray() {
		
		return this.jobArray;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public boolean getDishes() {
		
		return this.dishes;
		
	}
	
}
