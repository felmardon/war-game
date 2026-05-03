package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point for the War Game Simulation application.
 *
 * @author Felipe Mardones
 */
public class Driver {

	private static final Logger logger = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		logger.info("War Game Simulation CLI started");

		// Validate command-line arguments
		if (args.length == 0) {
			logger.warn("No configuration file provided");
			printUsage();
			System.exit(1);
		}

		logger.info("Loading configuration from: {}", args[0]);
		try {
			new MainApp(args[0]);
			logger.info("Application initialized successfully");
		}
		catch (FileNotFoundException e) {
			logger.error("Configuration file not found: {}", args[0], e);
			System.exit(1);
		}
		catch (IOException e) {
			logger.error("I/O exception while reading configuration file", e);
			System.exit(1);
		}
		catch (Exception e) {
			logger.error("Unexpected exception occurred: {}", e.getMessage(), e);
			System.exit(1);
		}
	}

	/**
	 * Prints usage information for the application.
	 */
	private static void printUsage() {
		System.out.println("Usage: java -jar war-game-simulation.jar <config-file>");
		System.out.println("  config-file: Path to the game configuration file");
	}
}