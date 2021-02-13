/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.stats.Stats;



/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class SourceComparator implements FilterInterface{
	Stats stats;
	

	public JSONArray period(Vector<String> sources, String state, int period) throws WrongValueException {
		
		JSONArray sourceEvents = new JSONArray();
		
		Iterator<String> it = sources.iterator();
		
		int i = 0;
		
		String maxSource = null;
		String minSource = null;
		int maxEvent = 0;
		int minEvent = 999999;
		
		while(it.hasNext()) {
			
			JSONObject object = new JSONObject();
			object = stats.getSourceEvents(state, it.next(), period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("source: ", sources.get(i));
			couple.put("totalEvents: ", totalElements);
			sourceEvents.put(couple);
			
			if(totalElements <= minEvent) {
				minEvent = totalElements;
				minSource = sources.get(i);
			}
			
			if (totalElements >= maxEvent) {
				maxEvent = totalElements;
				maxSource = sources.get(i);
			}

			i++;
				
			}
		
		JSONObject maxSourceEvents = new JSONObject();
		maxSourceEvents.put("Source with most events: ", maxSource);
		maxSourceEvents.put("totalEvents: ", maxEvent);
		JSONObject minSourceEvents = new JSONObject();
		minSourceEvents.put("source with least events: ", minSource);
		minSourceEvents.put("totalEvents: ", minEvent);
		
		sourceEvents.put(maxSourceEvents);
		sourceEvents.put(minSourceEvents);
		
		return sourceEvents;

	}
}
