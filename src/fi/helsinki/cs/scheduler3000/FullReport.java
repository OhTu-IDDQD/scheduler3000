package fi.helsinki.cs.scheduler3000;

/**
 * @author Team TA's
 */

import java.util.HashMap;


public class FullReport extends Report {

	public FullReport(Schedule schedule, HashMap<String, Object> options) {
		super(schedule, options);
	}

<<<<<<< HEAD
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


=======
        public String toString(){
            String res = "";
		
            for (Weekday.Day day : schedule.getSchedule().keySet()){
		res += day + ":\n";
		res += "----\n";
		for (Event event : schedule.getSchedule().get(day)){
			res += event.getTitle();
			res += "\nat " + event.getStartTime() + "-" + event.getEndTime();
			res += "\nin " + event.getLocation();
		}
		res += "\n\n";
            }
		
            return res;
	}
        
        public String toCSV() {
            return "testi";
        }
        
>>>>>>> 14c98bf94556c118ef254437b0a7e88966a9cf3f
}
