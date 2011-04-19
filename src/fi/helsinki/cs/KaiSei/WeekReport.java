package fi.helsinki.cs.KaiSei;


/**
 * @author Team TA's
 */


import java.util.ArrayList;
import java.util.HashMap;

import fi.helsinki.cs.KaiSei.Weekday.Day;

public class WeekReport extends Report {

        private final int MAX_TITLE_LENGTH = 10;

	public WeekReport(Schedule schedule, HashMap<String, Object> options) {
		super(schedule, options);
	}

	@Override
	public String toString() {

            String weekReport = "";
            int weekNo = 0;

            for (HashMap<Day, ArrayList<Event>> week : this.schedule.getSchedule()) {
                weekNo++;

		if (this.options.containsKey("days")){
			ArrayList<Weekday.Day> days =
                                (ArrayList<Day>)this.options.get("days");
			String[][] reportArray = new String[
                                Event.VALID_START_TIMES.length+1][days.size()+1]; // +1 for header row
                        // Nothing in the top left corner
			reportArray[0][0] = "Week " + weekNo;
                        // Add the start times
			for (int i = 1, j = 0; j < Event.VALID_START_TIMES.length; i++, j++){
				reportArray[i][0] = Event.VALID_START_TIMES[j];
			}

			int dayIndex = 1;
			for (Day day : days){
                                reportArray[0][dayIndex] = day.toString();
				ArrayList<Event> events = week.get(day); //this.schedule.getSchedule().get(day);

				if (events == null){
					return null;
				}

				for (Event event : events){
					String entry = null;

					if (event.getTitle() != null) {
                                            entry = event.getTitle();
					}
                                        int timeIndex = 0;
                                        // Find out when the event starts
                                        for (String startTime : Event.VALID_START_TIMES) {
                                            timeIndex++;
                                            if (event.getStartTime().equals(startTime)) {
                                                reportArray[timeIndex][dayIndex] = entry;
                                            }
                                        }
				}
				dayIndex++;
			}

			//String weekReport = "";
                        // Go through the array and append it to a string
			for (int i = 0; i < reportArray.length; i++){
				for (int j = 0; j < reportArray[0].length; j++){
                                        if (reportArray[i][j] != null) {
                                            // Cut the title if it's too long
                                            if (reportArray[i][j].length() > MAX_TITLE_LENGTH)
                                                weekReport += reportArray[i][j].substring(0,MAX_TITLE_LENGTH);
                                            else {
                                                // Pad the title string
                                                weekReport += String.format("%1$-"
                                                        + (MAX_TITLE_LENGTH) + "s", reportArray[i][j]);
                                            }
                                        }
                                        // Fill space with whitespace if there is no event
                                        else
                                            weekReport += String.format("%1$-" + MAX_TITLE_LENGTH + "s", "");
				}
				weekReport += "\n";
			}

			
		}
                
		
        }
        return weekReport;
        //return null;
    }
        
        public String toCSV() {
            
            int weekNo = 0;
            String weekReport = "";

            for (HashMap<Day, ArrayList<Event>> week : this.schedule.getSchedule()) {
                weekNo++;

		if (this.options.containsKey("days")){
			ArrayList<Weekday.Day> days =
                                (ArrayList<Day>)this.options.get("days");
			String[][] reportArray = new String[
                                Event.VALID_START_TIMES.length+1][days.size()+1]; // +1 for header row
                        // Nothing in the top left corner
			reportArray[0][0] = "Week " + weekNo;
                        // Add the start times
			for (int i = 1, j = 0; j < Event.VALID_START_TIMES.length; i++, j++){
				reportArray[i][0] = Event.VALID_START_TIMES[j];
			}

			int dayIndex = 1;
			for (Day day : days){
                                reportArray[0][dayIndex] = day.toString();
				ArrayList<Event> events = week.get(day);

				if (events == null){
					return null;
				}

				for (Event event : events){
					String entry = null;

					if (event.getTitle() != null) {
                                            entry = event.getTitle();
					}
                                        int timeIndex = 0;
                                        // Find out when the event starts
                                        for (String startTime : Event.VALID_START_TIMES) {
                                            timeIndex++;
                                            if (event.getStartTime().equals(startTime)) {
                                                reportArray[timeIndex][dayIndex] = entry;
                                            }
                                        }
				}
				dayIndex++;
			}

			
                        // Go through the array and append it to a string
			for (int i = 0; i < reportArray.length; i++){
				for (int j = 0; j < reportArray[0].length; j++){
                                        if (reportArray[i][j] != null) {
                                            weekReport += reportArray[i][j]+";";
                                        }
                                        // Fill space with whitespace if there is no event
                                        else
                                            weekReport += ";";
				}
				weekReport += "\n";
			}

			
		}
		//return null;
            }
            return weekReport;
        }

}
