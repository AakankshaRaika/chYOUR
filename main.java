import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {

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
}


/*import java.util.Scanner;
import java.io.*;

public class main{

    public static void main (String [] args) throws IOException{
        FileWriter fw= new FileWriter("FAQ.txt");  
        Scanner in= new Scanner (System.in);
        String testwords=in.nextLine();  
        fw.write(testwords);  
        BufferedReader r = new BufferedReader( new FileReader( "FAQ.txt" ) );  
        System.out.print(r);  
        fw.close();  
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main {

	public static void main (String[] args) {
		
		BufferedReader in = new BufferedReader(new FileReader("FAQ.txt"));
		String line;
			while((line = in.readLine()) != null)
			{
			    System.out.println(line);
			}
		in.close();
		

		
		java.io.File file = new java.io.File("FAQ.txt");
		try {
			Scanner input = new Scanner(file);
			while (input.hasNext()){
				String num = input.nextLine();
				System.out.println(num);
			}
		}
		catch (FileNotFoundException e){
			System.err.format("File not found\n");

		}
		

		
		BufferedReader br = new BufferedReader(new FileReader("FAQ.txt")){
			String line = null; 
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
			}
}
*/

