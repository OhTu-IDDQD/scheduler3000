package fi.helsinki.cs.scheduler3000;


/**
 * @author Team TA's
 */


import java.util.ArrayList;
import java.util.HashMap;

import fi.helsinki.cs.scheduler3000.Weekday.Day;

public class WeekReport extends Report {

	public WeekReport(Schedule schedule, HashMap<String, Object> options) {
		super(schedule, options);
	}

	@Override
/*	public String toString() {
		
		if (this.options.containsKey("days")){
			ArrayList<Weekday.Day> days = (ArrayList<Day>)this.options.get("days");			
			String[][] result = new String[days.size() + 1][7]; // +1 for header row

			result[0][0] = "\t";
			
			for (int i = 1, j = 0; j < Event.VALID_START_TIMES.length; i++, j++){
				result[0][i] = Event.VALID_START_TIMES[j] + "\t";
			}	

			int i = 1;
			for (Day day : days){
				result[i][0] = day.toString() + "\t";
				i++;
			}
			
			i = 1;
			for (Day d : days){		
				ArrayList<Event> events = this.schedule.getSchedule().get(d); 
				
				if (events == null){
					return null;
				}
				else if (events.size() == 0){
					for (int x = 1; x < 7; x++) {
						result[i][x] = "\t";
					}
				}
				
				for (Event event : events){
					String entry = "\t"; // if event is null
						
					if (event.getLocation() != null) { 
					  entry = event.getLocation()+"\t";
					}
					
					if (event.getStartTime().equals("08"))     { result[i][1] = entry; }
					else if(event.getStartTime().equals("10")) { result[i][2] = entry; }
					else if(event.getStartTime().equals("12")) { result[i][3] = entry;	}
					else if(event.getStartTime().equals("14")) { result[i][4] = entry; }
					else if(event.getStartTime().equals("16")) { result[i][5] = entry; }
					else if(event.getStartTime().equals("18")) { result[i][6] = entry; }
				
					// fill up with empties
					for (int x = 1; x < 7; x++) {
						if (result[i][x] == null){
							result[i][x] = "\t";
						}
					}
					
				}
				i++;
			}
						
			String response = "";
			
			for (int j = 0; j < result.length; j++){
				for (int k = 0; k < result[0].length; k++){
					response += result[j][k];
				}
				response += "\n";
			}
			
			return response;
		}
		return null;
	}
*/

	public String toString() {

		if (this.options.containsKey("days")){
			ArrayList<Weekday.Day> days = (ArrayList<Day>)this.options.get("days");
			String[][] result = new String[Event.VALID_START_TIMES.length+1][days.size()+1]; // +1 for header row

			result[0][0] = "\t";

			for (int i = 1, j = 0; j < Event.VALID_START_TIMES.length; i++, j++){
				result[i][0] = Event.VALID_START_TIMES[j] + "\t";
			}

/*			int i = 1;
			for (Day day : days){
				result[0][i] = day.toString() + "\t";
				i++;
			}
*/
			int i = 1;
			for (Day day : days){
                                result[0][i] = day.toString() + "\t";
//				i++;
				ArrayList<Event> events = this.schedule.getSchedule().get(day);

				if (events == null){
                                        System.out.println("hmm");
					return null;
				}
/*				else if (events.isEmpty()){
                                        System.out.println("jaajaa");
					for (int x = 1; x < 7; x++) {
						result[x][i] = "\t";
					}
				}
*/
				for (Event event : events){
                                        System.out.println("testi");
					String entry = "\t"; // if event is null

					if (event.getLocation() != null) {
					  entry = event.getLocation()+"\t";
					}
                                        int timeCount = 0;
                                        for (String startTime : Event.VALID_START_TIMES) {
                                            timeCount++;
                                            if (event.getStartTime().equals(startTime)) {
                                                result[timeCount][i] = entry;
                                            }
                                        }

/*					if (event.getStartTime().equals("08"))     { result[1][i] = entry; }
					else if(event.getStartTime().equals("10")) { result[2][i] = entry; }
					else if(event.getStartTime().equals("12")) { result[3][i] = entry; }
					else if(event.getStartTime().equals("14")) { result[4][i] = entry; }
					else if(event.getStartTime().equals("16")) { result[5][i] = entry; }
					else if(event.getStartTime().equals("18")) { result[6][i] = entry; }

					// fill up with empties
					for (int x = 1; x < days.size(); x++) {
						if (result[i][x] == null){
							result[i][x] = "\t";
						}
					}
*/
				}
				i++;
			}

			String response = "";

			for (int j = 0; j < result.length; j++){
				for (int k = 0; k < result[0].length; k++){
					response += result[j][k];
				}
				response += "\n";
			}

			return response;
		}
		return null;
        }


}
