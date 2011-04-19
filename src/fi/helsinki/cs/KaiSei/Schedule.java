package fi.helsinki.cs.KaiSei;

/**
 * @author Team TA's
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import fi.helsinki.cs.KaiSei.Weekday.Day;

public class Schedule implements Serializable {
	
    private String period;
    //private HashMap<Day, ArrayList<Event>> schedule;
    private ArrayList<HashMap<Day, ArrayList<Event>>> schedule;

    // CONSTRUCTORS
    
    // this constructor is solely for mock objects to use, hence protected
    protected Schedule(){ 
    	this.period = null;
    	this.schedule = null;
    }
    
/*    public Schedule(ArrayList<Day> week){
        this.setSchedule(week);
        this.period = null;
    }
    
    public Schedule(ArrayList<Day> week, String period){
    	this.setSchedule(week);
    	this.period = period;
    }
*/
    public Schedule(int noOfWeeks, String period){
        this.setSchedule(noOfWeeks, period);
    }

    // GETTERS AND SETTERS

    public void setSchedule(int noOfWeeks, String period) {
        if (this.schedule == null) {
            this.schedule = new ArrayList<HashMap<Day, ArrayList<Event>>>();
        }

        this.period = period;

        for (int i=0; i<noOfWeeks; i++) {
            HashMap week = new HashMap<Day, ArrayList<Event>>();
            Iterator iterator = Weekday.enumToIntMap.keySet().iterator();
            while (iterator.hasNext())
                week.put((Day) iterator.next(), new ArrayList<Event>());
            schedule.add(week);
        }
    }
 
/*    public void setSchedule(ArrayList<Day> newSchedule){
    	if (this.schedule == null){
    		this.schedule = new HashMap<Day, ArrayList<Event>>();
    	}
    	
    	// build schedule from given week, initialize empty event-arrays
        for (Day day : newSchedule){
        	this.schedule.put(day, new ArrayList<Event>());
        }
    }
    
    public void setSchedule(HashMap<Day, ArrayList<Event>> newSchedule){
    	this.schedule = newSchedule;
    }
 */
    public void setSchedule(Schedule newSchedule) {
		this.schedule = newSchedule.getSchedule();
		this.period = newSchedule.getPeriod();
	}

    public ArrayList<HashMap<Day, ArrayList<Event>>> getSchedule(){
		return this.schedule; 
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
    
    // OTHER
	public void addEvent(Day eventDay, Event event) {
/*		if (!this.schedule.containsKey(eventDay)){ // if adding an event to non-existent date
			throw new IllegalArgumentException("No such date in the schedule");
		}
*/
                for (HashMap<Day, ArrayList<Event>> week : schedule) {
                    week.get(eventDay).add(event);
                }
	}

        public void addEvent(Day eventDay, Event event, ArrayList<Integer> weeks) {
            for (int week : weeks) {
                System.out.print("week " + week + "...");
                this.schedule.get(week-1).get(eventDay).add(event);
            }
        }


}

