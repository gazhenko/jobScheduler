
public class JobAssigner {
	
	// constants
	private static final String LR = "livingroom";
	private static final String BR = "bathroom";
	private static final String KT = "kitchen";
	private static final String DS = "dishes";
	
	public static String assign(Person person) {
		
		String job = "";
		
		// logic goes here 
		String currentJob = 
				person.getJobArray().get(person.getJobArray().size() - 1);
		String previousJob = 
				person.getJobArray().get(person.getJobArray().size() - 2);
		
		if (person.getDishes()) {
			
			if (currentJob.equals(DS)) {
				
				// LR -> KT
				if (previousJob.equals(LR)){
					
					job = KT;
					
				}
				// KT -> BR
				if (previousJob.equals(KT)){
					
					job = BR;
					
				}
				// BR -> LR
				if (previousJob.equals(BR)){
					
					job = LR;
	
				}
				
			}
			else {
				
				job = DS;
				
			}
			
		}
		else {
			
			// LR -> BR
			if (currentJob.equals(LR)) {
				
				job = BR;
				
			}
			// BR -> KT
			else if (currentJob.equals(BR)) {
				
				job = KT;
				
			}
			// KT -> LR
			else if (currentJob.equals(KT)) {
				
				job = LR;
				
			}
			
		}
		return job;
		
	}
	
}
