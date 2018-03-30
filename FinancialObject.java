import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This is the superclass being used to base all our subclasses off of


public abstract class FinancialObject {
	
	String symbol;
	String market;
	Boolean consoleView = false;
	

	public void setSymbol(String mySymbol){
		
		symbol = mySymbol;
	}
	
	public void setMarket(String myMarket){
		
		market = myMarket;
		}
		
	// abstract classes that are defined with different method bodies in the subclasses
	
	public abstract void compareValues();
	
	public abstract void setInitialValues();
	
			
	// Check if user wants to display output on screen
	public void setConsoleInput(int x){
		
		if (x == 1)
			consoleView = true;
		
		else consoleView = false;		
	}	
	
	
	public void printOutput(String s) throws Exception {
		
		File file = new File("word.txt");
		PrintWriter writer = new PrintWriter(new FileWriter(file,true));
		BufferedWriter buff = new BufferedWriter(writer);
		

		buff.write(s);
		buff.newLine();
		buff.flush();
		buff.close();
		
	}
	
	public String getDate(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public abstract boolean validateCallSymbol(String inputSymbol) throws IOException;
	
}


		


