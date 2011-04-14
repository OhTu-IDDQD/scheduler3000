package tests;

/**
 * @author Team TA's
 */


import org.junit.* ;

import fi.helsinki.cs.KaiSei.*;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportTest extends TestCase {

	MockSchedule sched;
	HashMap<String, Object> options;
	final String STARTTIME = "08", ENDTIME = "12", TITLE = "title", LOCATION = "location"; 

	@Before
	public void setUp() throws Exception {
		ArrayList<Weekday.Day> weekdays = new ArrayList<Weekday.Day>();
		weekdays.add(Weekday.Day.MON);
		weekdays.add(Weekday.Day.THU);

		sched = new MockSchedule(weekdays);
		sched.addEvent(Weekday.Day.MON, new Event(STARTTIME, ENDTIME, TITLE, LOCATION));
		
		options = new HashMap<String, Object>();

	}


	@After
	public void tearDown() throws Exception {
		sched = null;
		options = null;
	}

	@Test
	public void testDayReport(){
		// make options
		options.put("day", Weekday.Day.MON);
		 
                DayReport r = new DayReport(sched,options);
		assertTrue(r.toString() != null);
		assertTrue(r.toString().contains(Weekday.longNameMap.get(Weekday.Day.MON)));
	}

	@Test
	public void testDayReportWithEmptyOptions(){
		// options are empty after setUp
		
                DayReport r = new DayReport(sched,options);
		assertNull(r.toString());
	}

	
	@Test
	public void testDayReportWithFalseOptions(){
		options.put("day", Weekday.Day.SAT); // no Saturday in schedule
		
                DayReport r = new DayReport(sched,options);
		assertNull(r.toString());
	}

	@Test
	public void testWeekReport(){
		// make options
		ArrayList<Weekday.Day> daylist = new ArrayList<Weekday.Day>();
		daylist.add(Weekday.Day.MON);
		daylist.add(Weekday.Day.THU);
		options.put("days", daylist);
		
                WeekReport r = new WeekReport(sched,options);
		assertTrue(r.toString() != null);
		assertTrue(r.toString().contains("MON"));
		assertTrue(r.toString().contains("THU"));
	}
	
	@Test
	public void testWeekReportWithFalseOptions(){
		// make options
		ArrayList<Weekday.Day> daylist = new ArrayList<Weekday.Day>();
		daylist.add(Weekday.Day.MON);
		daylist.add(Weekday.Day.THU);
		daylist.add(Weekday.Day.FRI);
		options.put("days", daylist);
		
                WeekReport r = new WeekReport(sched,options);
		assertNull(r.toString());
	}
	
	@Test
	public void testWeekReportWithNoOptions(){
		// options are empty after setUp
		
                WeekReport r = new WeekReport(sched,options);
		assertNull(r.toString());
	}
	
	@Test
	public void testFullRaport(){
                FullReport r = new FullReport(sched,options);
		assertTrue(r.toString() != null);
		
		// full report holds label for Monday
		assertTrue(r.toString().contains("MON")); 
		
		// full report holds single event
		assertTrue(r.toString().contains(STARTTIME));
		assertTrue(r.toString().contains(ENDTIME));
		assertTrue(r.toString().contains(TITLE));
		assertTrue(r.toString().contains(LOCATION));
		
		// full report holds label for Thursday
		assertTrue(r.toString().contains("THU"));
		
	}
	
	
	
	/**
	 * Cannot test the last line (default value, which is set to 'null'
	 * as there are only three values set in enum that the program accepts:
	 * DAY, WEEK and FULL 
	@Test
	public void testIfNull(){
		Report r4 = ReportFactory.makeReport(null, sched, mapper);
		assertNull(r4);
	}
	*/

}
	