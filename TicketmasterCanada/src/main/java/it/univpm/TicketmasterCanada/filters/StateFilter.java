/**
 * 
 */
package it.univpm.TicketmasterCanada.filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */

/**
 * Implementa MarketCountryInterface e contiene i metodi per filtrare gli eventi
 * in uno Stato in funzione del periodo su cui si vuole effettuare tale ricerca
 */
public class StateFilter implements MarketStateInterface {
	Stats stats = new StatsImplementation();

	public JSONArray periodMarketState(Vector<String> states, int period) throws WrongStateException {

		JSONArray stateEvents = new JSONArray(); // creo un array

		Iterator<String> it = states.iterator(); // inizializzo un iteratore con gli stati passati come paramentri

		int i = 0;

		String maxState = null; // Stato che contiente il maggior numero di eventi
		String minState = null; // Stato che contiente il minor numero di eventi
		int maxEvent = 0; // Numero di eventi maggiore
		int minEvent = 999999; // Numero di eventi minore
		int totEvent =0;

		while (it.hasNext()) { // ciclo che si conclude dopo aver scorso tutto il vettore con gli States

			JSONObject object = new JSONObject();
			object = stats.getStateEvents(it.next(), period); // chiamata al metodo getStateEvents a cui si passa lo
																// state i-esimo e il periodo preso in esame
			int totalElements = object.getInt("totalEvents");

			totEvent = totEvent+totalElements;
			JSONObject couple = new JSONObject();
			couple.put("state", states.get(i)); // Inserisco il codice dello Stato esaminato nel coppia stato-numero
												// eventi
			couple.put("totalEvents", totalElements); // Inserisco il numero di eventi dello Stato esaminato nel coppia
														// stato-numero eventi

			stateEvents.put(couple);

			if (totalElements <= minEvent) { // Salvo lo stato con meno eventi
				minEvent = totalElements;
				minState = states.get(i);
			}

			if (totalElements >= maxEvent) { // Salvo lo stato con più eventi
				maxEvent = totalElements;
				maxState = states.get(i);
			}

			i++;

		}

		JSONObject maxStateEvents = new JSONObject(); // Salvo il nome e il numero di eventi dello Stato con più eventi
														// all'interno di un JSONObject
		maxStateEvents.put("State with most events", maxState);
		maxStateEvents.put("Events", maxEvent);
		JSONObject minStateEvents = new JSONObject(); // Salvo il nome e il numero di eventi dello Stato con meno eventi
														// all'interno di un JSONObject
		minStateEvents.put("State with least events", minState);
		minStateEvents.put("Events", minEvent);
		
		JSONObject totalEvents = new JSONObject();
		totalEvents.put("Total Events", totEvent);

		
		stateEvents.put(maxStateEvents); // Inserisco il JSONOBject dellos stati con più eventi all'interno del
											// JSONArray finale
		stateEvents.put(minStateEvents); // Inserisco il JSONOBject dellos stati con meno eventi all'interno del
											// JSONArray finale
		stateEvents.put(totalEvents);

		return stateEvents;

	}

}