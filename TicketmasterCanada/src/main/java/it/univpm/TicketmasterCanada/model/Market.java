package it.univpm.TicketmasterCanada.model;

/**
 * @author Fabio Carosi
 * @author Mattia Girolami
 */
public class Market {
	
	private String marketID; 		//rappresenta l'id di un ampio raggruppamento geografico
	private String marketName; 		//rappresenta il nome di un ampio raggruppamento geografico
	
	/**
	 * Metodo che restituisce il:
	 * @return the marketID
	 */
	public String getMarketID() {
		return marketID;
	}
	
	/**
	 * Metodo che setta il:
	 * @param marketID the marketID to set
	 */
	public void setMarketID(String marketID) {
		this.marketID = marketID;
	}
	
	/**
	 * Metodo che restituisce il:
	 * @return the marketName
	 */
	public String getMarketName() {
		return marketName;
	}
	
	/**
	 * Metodo che setta il:
	 * @param marketName the marketName to set
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
	/**
	 * Costruttore con parametri:
	 * @param marketID
	 * @param marketName
	 */
	public Market(String marketID, String marketName) {
		super();
		this.marketID = marketID;
		this.marketName = marketName;
	}
	
	/**
	 * Costruttore con parametro:
	 * @param marketID
	 */
	public Market(String marketID) {
		super();
		this.marketID = marketID;
		this.marketName = null;
	}
	
	
	/**
	 * Costruttore vuoto.
	 */
	public Market() {
		super();
		this.marketID = null;
		this.marketName = null;
	}
	
	/**
	 * Override del metodo toString.
	 */
	@Override
	public String toString() {
		return "marketID=" + marketID + ", marketName=" + marketName;
	}

	/*
	 * Override del metodo equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Market other = (Market) obj;
		if (marketID == null) {
			if (other.marketID != null)
				return false;
		} else if (!marketID.equals(other.marketID))
			return false;
		if (marketName == null) {
			if (other.marketName != null)
				return false;
		} else if (!marketName.equals(other.marketName))
			return false;
		return true;
	}
	
	
	
}
