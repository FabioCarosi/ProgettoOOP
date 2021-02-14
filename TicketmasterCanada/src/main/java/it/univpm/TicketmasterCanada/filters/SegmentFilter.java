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
		
		String maxState = null;	//Stato che contiente il maggior numero di eventi
		String minState = null;	//Stato che contiente il minor numero di eventi
		int maxEvent = 0;		//Numero di eventi maggiore
		int minEvent = 999999;	//Numero di eventi minore
		
		while(it.hasNext()) {	//ciclo che si conclude dopo aver scorso tutto il vettore con gli States
			
			JSONObject object = new JSONObject();
			object = stats.getSegmentEvents(it.next(), segment, period);
			int totalElements = object.getInt("totalEvents");
			
			JSONObject couple = new JSONObject();
			couple.put("state: ", states.get(i));			//Inserisco il codice dello Stato esaminato nel coppia stato-numero eventi
			couple.put("totalEvents: ", totalElements);		//Inserisco il numero di eventi dello Stato esaminato nel coppia stato-numero eventi
			segmentEvents.put(couple);
			
			if(totalElements <= minEvent) {		//Salvo lo stato con meno eventi
				minEvent=totalElements;
				minState = states.get(i);
			}
			
			if (totalElements >= maxEvent) {	//Salvo lo stato con piu' eventi
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;
				
			}
		
		JSONObject maxStateEvents = new JSONObject();	//Salvo il nome e il numero di eventi dello Stato con più eventi all'interno di un JSONObject
		maxStateEvents.put("State with most events: ", maxState);
		maxStateEvents.put("totalEvents: ", maxEvent);
		JSONObject minStateEvents = new JSONObject();	//Salvo il nome e il numero di eventi dello Stato con meno eventi all'interno di un JSONObject
		minStateEvents.put("State with least events: ", minState);
		minStateEvents.put("totalEvents: ", minEvent);
		
		segmentEvents.put(maxStateEvents);	//Inserisco il JSONOBject dellos stati con più eventi all'interno del JSONArray finale
		segmentEvents.put(minStateEvents);	//Inserisco il JSONOBject dellos stati con meno eventi all'interno del JSONArray finale
		
		return segmentEvents;
	}
	
}