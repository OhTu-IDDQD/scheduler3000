package fi.helsinki.cs.scheduler3000;

/**
 * @author Team TA's
 */


import java.util.HashMap;

public abstract class Report {

	// visible to subclasses
	protected Schedule schedule;
	protected HashMap<String, Object> options;
	
	public Report(Schedule schedule, HashMap<String, Object> options) {
		this.schedule = schedule;
		this.options = options;
	}	
}
