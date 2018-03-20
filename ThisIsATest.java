import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;
public class ThisIsATest {
	
	// MAIN TEST CLASS THAT ACTUALLY WORKS (SOMETIMES)
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter a Stock ticker Symbol");
		
		String symbolString = input.nextLine();
		
		System.out.println("Please enter desired gain in percentage (ex. 0.10)");
		
		double percentage = input.nextDouble() + 1.0;
		
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbolString + endString;

		double initialPrice = -1.00;

		double currentPrice = -1.00;

		double targetPrice = -1.00;




		
		
		
		while (true) {	
		
		
	
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String price = "no price available";
	
			line = buff.readLine();
	
	
	
			while (line != null) {
				
				
	
		
		
		
				if (line.contains("price")){
		
					int index = line.indexOf("price");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
			
					price = line.substring(start + 1, decimal + 5);
					currentPrice = Double.parseDouble(price);
			
					if (initialPrice == -1.00){
						initialPrice = Double.parseDouble(price);
						targetPrice = initialPrice * percentage;
					}
				
				
					System.out.println("Initial Price is " + initialPrice + "\n");
					System.out.println("Current Price is " + currentPrice + "\n"); 
					System.out.println("Target Price is " + targetPrice + "\n\n\n");
			
					if (currentPrice >= targetPrice)
						System.out.println("Desired Percentage Gain Achieved\n\n");
		
				}
			
	
		line = buff.readLine();
	
	
	
			}
	
	
	}
	
	catch (MalformedURLException e) {
		   System.err.println("SHIT??");
	}
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	try {
		
		Thread.sleep(1 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
	}
	
	}

}

