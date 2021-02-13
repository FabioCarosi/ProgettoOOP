/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;
/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

public class SegmentFilter {
	
	Stats stats = new StatsImplementation();
	
	public JSONArray period(Vector<String> states, String segment, int period) {
		
		JSONArray segmentEvents = new JSONArray();
		
		Iterator<String> it = states.iterator();
		
		int i = 0;
		
		String maxState = null;
		String minState = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(it.next(), segment, period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("state: ", states.get(i));
			couple.put("totalEvents: ", totalElements);
			segmentEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent=totalElements;
				minState = states.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;
				
			}
		
		JSONObject maxStateEvents = new JSONObject();
		maxStateEvents.put("State with most events: ", maxState);
		maxStateEvents.put("totalEvents: ", maxEvent);
		JSONObject minStateEvents = new JSONObject();
		minStateEvents.put("State with least events: ", minState);
		minStateEvents.put("totalEvents: ", minEvent);
		
		segmentEvents.put(maxStateEvents);
		segmentEvents.put(minStateEvents);
		
		return segmentEvents;
	}
	
}
