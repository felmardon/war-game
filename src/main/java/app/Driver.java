package app;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Entry point for the War Game Simulation application.
 *
 * @author Felipe Mardones
 */
public class Driver {

	static void main(String[] args) {
		// Validate command-line arguments
		if (args.length == 0) {
			printUsage();
			System.exit(1);
		}

		try {
			new MainApp(args[0]);
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: Configuration file not found: " + args[0]);
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error: I/O exception while reading configuration file");
			System.exit(1);
		}
		catch (Exception e) {
			System.err.println("Error: Unexpected exception occurred: " + e.getMessage());
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