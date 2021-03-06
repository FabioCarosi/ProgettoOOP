package it.univpm.TicketmasterCanada.filters;

import java.util.Vector;

import org.json.JSONArray;

import it.univpm.TicketmasterCanada.exception.*;
import it.univpm.TicketmasterCanada.stats.Stats;
import it.univpm.TicketmasterCanada.stats.StatsImplementation;

/**
 * @author Mattia Girolami
 * @author Fabio Carosi 
 */

/**
 * La classe Filters contiene i metodi necessari per poter utilizzare i filtri.
 */

public class Filters {
	private Vector<String> states = new Vector<String>();
	private String parameter;
	private int period;
	private String value;
	private String comparator;
	
	
    
	/**
	 * Costruttore vuoto
	 */
	public Filters() {
		super();
	}

	Stats stats = new StatsImplementation();

	/**
	 * Costruttore con parametri:
	 * 
	 * @param states Vector di stinghe contenente i nomi degli stati da filtrare
	 * @param parameter parameteretro per poter effettuare il filtraggio
	 * @param period lasso di tempo in mesi utilizzato per filtrare
	 * @param value valore assunto dal parameteretro
	 * @param comparator String che permette all'utente di poter scegliere cosa
	 *            confrontare
	 */
	public Filters(String comparator, Vector<String> states, String parameter, String value, int period) {
		super();
		this.comparator = comparator;
		this.states = states;
		this.parameter = parameter;
		this.value = value;
		this.period = period;
	}
	
	
	
	
	public JSONArray filtersImplementation() throws WrongPeriodException, WrongParameterException, WrongValueException,
			WrongComparatorException, WrongStateException {

		JSONArray array = new JSONArray();
		
		if (comparator.equals("country")) {
			Vector<String> countries = new Vector<String>();

		    countries.add("BC");
		    countries.add("AB");
		    countries.add("SK");
		    countries.add("MB");
		    countries.add("ON");
		    countries.add("QC");
		    countries.add("NB");
		    countries.add("NS");
		    countries.add("PE");
		    countries.add("NL");
		    countries.add("YT");
		    countries.add("NT");
		    countries.add("NU");
		    
			if (period == 1) {
				

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(countries, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(countries, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 3) {
				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(countries, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(countries, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 6) {

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(countries, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(countries, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 12) {

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(countries, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(countries, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(countries, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");
			}

			else
				throw new WrongPeriodException(period + " non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12");
		}

		else if (comparator.equals("state")) {

			if (period == 1) {

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(states, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 3) {
				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(states, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 6) {

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(states, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");

			} else if (period == 12) {

				if (parameter.equals("total")) {
					StateFilter filter = new StateFilter();
					array = filter.periodMarketState(states, period);
				} else if (parameter.equals("source")) {
					SourceFilter filter = new SourceFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("genre")) {
					GenreFilter filter = new GenreFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("segment")) {
					SegmentFilter filter = new SegmentFilter();
					array = filter.period(states, value, period);
				} else if (parameter.equals("subgenre")) {
					SubGenreFilter filter = new SubGenreFilter();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è accettato. Scegli tra: total, source, segment, genre e subgenre.");
			}

			else
				throw new WrongPeriodException(period + " non è ammesso. Inserisci un period uguale a 1, 3, 6 o 12");

		} else if (comparator.equals("market")) {

			if (period == 1) {

				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketState(states, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 3) {

				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketState(states, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa total.");

			} else if (period == 6) {

				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketState(states, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
			} else if (period == 12) {
				if (parameter.equals("total")) {
					MarketIdFilter filter = new MarketIdFilter();
					array = filter.periodMarketState(states, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa total.");
			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("source")) {

			if (period == 1) {
				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa state.");
			} else if (period == 3) {

				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa state.");
			}

			else if (period == 6) {

				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 12) {

				if (parameter.equals("state")) {
					SourceComparator filter = new SourceComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parameteretro ammesso. Puoi inserire solo la stringa state.");

			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");

		} else if (comparator.equals("segment")) {

			if (period == 1) {

				if (parameter.equals("state")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");
			}

			else if (period == 3) {

				if (parameter.equals("state")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");
			}

			else if (period == 6) {

				if (parameter.equals("state")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 12) {

				if (parameter.equals("state")) {
					SegmentComparator filter = new SegmentComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");
			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("genre")) {

			if (period == 1) {

				if (parameter.equals("state")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 3) {

				if (parameter.equals("state")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 6) {

				if (parameter.equals("state")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 12) {

				if (parameter.equals("state")) {
					GenreComparator filter = new GenreComparator();
					array = filter.period(states, value, period);
				} else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");
			} else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");
		}

		else if (comparator.equals("subgenre")) {

			if (period == 1) {

				if (parameter.equals("state")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 3) {

				if (parameter.equals("state")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 6) {

				if (parameter.equals("state")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else if (period == 12) {

				if (parameter.equals("state")) {
					SubGenreComparator filter = new SubGenreComparator();
					array = filter.period(states, value, period);
				}

				else
					throw new WrongParameterException(
							parameter + " non è un parametro ammesso. Puoi inserire solo la stringa state.");

			}

			else
				throw new WrongPeriodException(
						period + " non è un numero ammesso. Inserisci un numero tra 1, 3, 6 oppure 12.");

		}

		else
			throw new WrongComparatorException(comparator + " non è una stringa ammessa. Inserisci una stringa tra "
					+ "country, state, market, source, segment, genre o subgenre.");

		return array;
	}
}

