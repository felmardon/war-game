/**
 * @author Felipe Mardones
 * @version 1.0
 * 
 * True driver of the war game simulation. Manages the game state and player interactions.
 *
 * TODO: Migrate from deprecated Applet to JavaFX for GUI rendering when web UI is planned
 */

package app;

import java.util.concurrent.*;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainApp implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	// TODO: Initialize board when game is fully implemented
	// private Board map;

	/**
	 * Initializes the main application with a configuration file.
	 *
	 * @param fileName Path to the configuration file
	 * @throws FileNotFoundException if the configuration file is not found
	 * @throws IOException if an I/O error occurs
	 */
	public MainApp(String fileName) throws FileNotFoundException, IOException {
		logger.debug("Initializing MainApp with configuration file: {}", fileName);

		File file = new File(fileName);
		if (!file.exists()) {
			logger.error("Configuration file does not exist: {}", fileName);
			throw new FileNotFoundException("Configuration file not found: " + fileName);
		}

		logger.info("Configuration file validated: {}", file.getAbsolutePath());
		// TODO: Load configuration from file
		// TODO: Initialize game state
	}

	@Override
	public void run() {
		logger.debug("Running MainApp game loop");
		// TODO: Implement game loop
		// Semaphore sem = new Semaphore(1);

		// TODO: Create Player class
		// Player player1 = new Player(sem);
		// Player player2 = new Player(sem);

		// player1.start();
		// player2.start();
	}
}