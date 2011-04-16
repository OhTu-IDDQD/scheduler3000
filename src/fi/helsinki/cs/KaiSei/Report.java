package fi.helsinki.cs.KaiSei;

/**
 * @author Team TA's
 */


import java.util.HashMap;

abstract class Report {

	// visible to subclasses
	protected Schedule schedule;
	protected HashMap<String, Object> options;
	
	public Report(Schedule schedule, HashMap<String, Object> options) {
		this.schedule = schedule;
		this.options = options;
	}

        public static enum ReportType { DAY, WEEK, FULL }
        
        abstract public String toCSV();
	abstract public String toString();

}