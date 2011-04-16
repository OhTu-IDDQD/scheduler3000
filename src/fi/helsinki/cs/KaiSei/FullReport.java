package fi.helsinki.cs.KaiSei;

/**
 * @author Team TA's
 */

import java.util.HashMap;


public class FullReport extends Report {

	public FullReport(Schedule schedule, HashMap<String, Object> options) {
		super(schedule, options);
	}

        @Override
	public String toString(){
		String result = "";

		for (Weekday.Day day : schedule.getSchedule().keySet()){
			result += day + ":\n";
			result += "----\n";
			for (Event event : schedule.getSchedule().get(day)){
				result += event.getTitle();
				result += "\nat " + event.getStartTime() + "-" + event.getEndTime();
				result += "\nin " + event.getLocation();
			}
			result += "\n\n";
		}

		return result;
	}
        
        public String toCSV() {
            return "testi";
        }
}
