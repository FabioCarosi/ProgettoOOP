/**
 * 
 */
package it.univpm.TicketmasterCanada.exception;

/**
 * @author caros
 *
 */
public class WrongParameterException {

	String message;
	
	public WrongParameterException(String message) {
		
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}