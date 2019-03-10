/**
 * @author Felipe Mardones
 * @version 1.0
 * 
 * True driver of the war game simulation. Creates a window to display
 * the game to the human player, and allows for interaction.
 */

package app;

import java.applet.*;
import java.util.concurrent.*;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import model.map.Board;

@SuppressWarnings("serial")
public class MainApp extends Applet implements Runnable {
	
	Board map;
	
	public MainApp(String fileName) throws FileNotFoundException, IOException, JAXBException, InterruptedException {
		super();
		
		File file = new File(fileName);
		if (file.exists()) {
			return;
		}
	}
	
	public void init() {
		this.run();
	}
	

	public void run() {
		Semaphore sem = new Semaphore(1);
		
		Thread player1 = new Thread();
		Thread player2 = new Thread();
		
		player1.start();
		player2.start();
		
		try {
			player1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}