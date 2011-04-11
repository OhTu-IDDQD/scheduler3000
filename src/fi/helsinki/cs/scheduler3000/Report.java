package fi.helsinki.cs.scheduler3000;

/**
 * @author Team TA's
 */


import java.util.HashMap;

<<<<<<< HEAD
public abstract class Report {
=======
abstract class Report {
>>>>>>> 14c98bf94556c118ef254437b0a7e88966a9cf3f

	// visible to subclasses
	protected Schedule schedule;
	protected HashMap<String, Object> options;
	
	public Report(Schedule schedule, HashMap<String, Object> options) {
		this.schedule = schedule;
		this.options = options;
<<<<<<< HEAD
	}	
=======
	}

        public static enum ReportType { DAY, WEEK, FULL }
        
        abstract public String toCSV();
	abstract public String toString();
        
>>>>>>> 14c98bf94556c118ef254437b0a7e88966a9cf3f
}
