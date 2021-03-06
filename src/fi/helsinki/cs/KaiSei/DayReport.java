package fi.helsinki.cs.KaiSei;

/**
 * @author Team TA's
 */


import java.util.ArrayList;
import java.util.HashMap;

import fi.helsinki.cs.KaiSei.Weekday.Day;

public class DayReport extends Report {

	public DayReport(Schedule schedule, HashMap<String, Object> options) {
		super(schedule, options);
	}
	
	
	@Override
	public String toString() {
		if (this.options.containsKey("day")){
			String result = "";
			Weekday.Day weekday = (Day)this.options.get("day");
			ArrayList<Event> events = this.schedule.getSchedule().get(weekday);
			
			if (events == null) {
				return null;
			}
			
			result += Weekday.longNameMap.get(weekday) + ":\n------\n";
			
			for (Event e : events){
				if(e.getTitle().equals("")){
					result += "<no title for this event>";
				}
				else{
					result += e.getTitle();
				}
				
				//event must always have start time and end time
				result += "\nat " + e.getStartTime() + " to " + e.getEndTime();
				
				if (e.getLocation().equals("")){
					result += "\n<no location specified>";
				}
				else {
					result += "\nin " + e.getLocation();
				}
				result += "\n\n";
			}
			return result;
		}

		return null;
	}
        
        public String toCSV() {
            return "testi";
        }
	
}
