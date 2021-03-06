/**
 * 
 */
package it.univpm.TicketmasterCanada.files;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.TicketmasterCanada.exception.WrongStateException;
import it.univpm.TicketmasterCanada.exception.WrongValueException;


/**
 * @author Mattia Girolami
 * @author Fabio Carosi
 */

public class GetImportantEventsTest {
	
	GetImportantEvents file;
	
	/**
	 * Inizializza le componenti necessarie per i test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		file = new GetImportantEvents();
		}
	
	/**
	 * Distrugge quello che è stato creato dal BeforeEach.
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test che controlla il corretto salvataggio del file.
	 * @throws IOException
	 * @throws WrongValueException 
	 * @throws WrongStateException 
	 */
	@Test
	@DisplayName("Salvataggio del file avvenuto in modo corretto")
	void fileSaver() throws IOException, WrongStateException, WrongValueException {
		
		String countryCode = "CA";
		
		String segment = "Sports";
		
		String nomeDirectory = "Most_important_event";

		String pathDirectory = System.getProperty("user.dir") + "/" + nomeDirectory;

		String nomeFile = "CA" + "_Most_Important_Event";

		String pathFile = pathDirectory + "/" + nomeFile + ".txt";
		
		File filex = new File(pathFile);
 
		try{
			if (!filex.exists()) {
				filex.createNewFile();
			}
		} catch (IOException e) {
			System.out.println(e);
		}		
		assertEquals(pathFile, file.SaveImportantStateEvents(countryCode, segment));			
	}
	
	
	/**
	 * Test che verifica la corretta creazione della directory.
	 * @throws IOException
	 * @throws WrongValueException 
	 * @throws WrongStateException 
	 */
	@Test
	@DisplayName("Creazione della directory avvenuta in modo corretto")
	void directorySaver() throws IOException, WrongStateException, WrongValueException {
		
		String countryCode = "CA";
		
		String segment = "Sports";
		
		String path = file.SaveImportantStateEvents(countryCode, segment);
		
		path.replaceAll("/CA_Most_Important_Event", "");
				
		assertEquals(path, file.SaveImportantStateEvents(countryCode, segment));
		
	}
}
