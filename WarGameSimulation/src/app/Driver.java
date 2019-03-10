package app;

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

public class Driver {
	public static void main(String[] args) {
		try {
			new MainApp(args[0]);
		}
		
		catch (JAXBException jaxbException) {
			System.err.println("Error! JAXBException caught");
		}
		
		catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error! FileNotFoundException caught");
		}

		catch (IOException ioException) {
			System.err.println("Error! IOException caught");
		}

		catch (Exception exception) {
			System.err.println("Error! Exception caught");
		}
	}
}