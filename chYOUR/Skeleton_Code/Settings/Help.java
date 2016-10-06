package Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Skeleton code author : @aakanksh @yosephh 
 * Task Owners sprint 2 : Aakanskha and Barry
 */
public class Help {

	/*
	 * Make FAQ page // Done
	 * how to use app page  // Done
	 * what are default locations page // Done
	 * contact us page
	 */
	BufferedReader br = null;

	try {

		String sCurrentLine;

		br = new BufferedReader(new FileReader("FAQ.txt"));

		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	BufferedReader br2 = null;

	try {

		String sCurrentLine;

		br2 = new BufferedReader(new FileReader("UserGuide.txt"));

		while ((sCurrentLine = br2.readLine()) != null) {
			System.out.println(sCurrentLine);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br2 != null)br2.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
}
