import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CryptoPrice extends FinancialObject {


	double percentage;
	double initialValue;
	double positivePercentage;
	double negativePercentage;
	double highTarget;
	double lowTarget;
	
	
	public void setPercentage(double myPercentage){
		if(myPercentage > 0)
		{
			positivePercentage = myPercentage/100.00 + 1.00;
		}
		else if(myPercentage < 0)
		{
			negativePercentage = myPercentage/100.00 +1.00;
		}
	}
	
	
	@Override
	public void compareValues() {

		double currentVal = 0.0;
		String endString ="&apikey=U7CEKTSD7MP0A660";
		String myString = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=" + symbol + "&market=USD" + endString;

		

		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String price = "no price available";
	
			line = buff.readLine();
	
	
	
			while (line != null && currentVal == 0.0) {

				if (line.contains("price")){
		
					int index = line.indexOf("price");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
			
					price = line.substring(start + 1, decimal + 5);
					currentVal = Double.parseDouble(price);
					
					
					if (consoleView) {
						
					System.out.printf("Initial value for " + symbol + " is %.2f%n",initialValue);
					System.out.println("");
					System.out.printf("Target high value is %.2f%n",highTarget);
					System.out.println("");	
					System.out.printf("Target low value is %.2f%n",lowTarget);
					System.out.println("");	
					System.out.printf("Current value is %.2f%n",currentVal);
					System.out.println("");
					System.out.println("-------------------------------------------------------------------");
					
					}
					
					
					
					
					
					if (currentVal > highTarget) {
												
						System.out.println("****************  Your upper target price for " + symbol + " has been reached  ************************");					
						
						System.out.println("-------------------------------------------------------------------");
												
					}
					
					else if (currentVal < lowTarget) {
					
					System.out.println("****************  Your lower target price for " + symbol + " has been reached  ************************");
					
					System.out.println("-------------------------------------------------------------------");
					}
							
				
					
					
				}

		line = buff.readLine();

			}
	}
	
	catch (MalformedURLException e) {
		   System.err.println("Connection error. Please restart the program.");
	}
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	try {
		
		Thread.sleep(2 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
		
	}

	@Override
	public void setInitialValues() {
		
				
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=" + symbol + "&market=USD" + endString;
		
		initialValue = -1.00;
		
					
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String price = "no price available";
	
			line = buff.readLine();
			
			while (line != null && initialValue == -1.0) {
				

				if (line.contains("price")){
		
					int index = line.indexOf("price");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
			
					price = line.substring(start + 1, decimal + 5);
					initialValue = Double.parseDouble(price);
					
					highTarget = initialValue * positivePercentage;
					lowTarget = initialValue * negativePercentage;
										

				}
			
	
		line = buff.readLine();
	
			}

	}
	
	catch (MalformedURLException e) {
		   System.err.println("Connection error. Please restart the program.");
	}
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	try {
		
		Thread.sleep(2 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
	
	}

	@Override
	public boolean validateCallSymbol(String inputSymbol) throws IOException {
		symbol = inputSymbol;
		String str = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=" + symbol + "&market=USD&apikey=U7CEKTSD7MP0A660";
		int lineIndex = 0;
		boolean valid = true;
		
		
		URL url = new URL(str);

		URLConnection hc = url.openConnection();

		InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
		
		BufferedReader buff = new BufferedReader(mystream);
		
		String line = buff.readLine();
		
		while (line != null && lineIndex <2) {
						
			/* API call for BATCH_STOCK_QUOTES query never returns error even with wrong stock ticker input
			  we can only check for [] in output to see that an invalid or no input was used.
			 */
			if (line.contains("Error"))
				valid = false;
			
			line = buff.readLine();
			lineIndex ++;
		}
		return valid;
	}
	
	public double getPrice(){
		

		String endString ="&apikey=U7CEKTSD7MP0A660";
		String myString = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_INTRADAY&symbol=" + symbol + "&market=USD" + endString;
		String priceStr = "no price available";	
		double price = 0;

		

		try {
	
			URL url = new URL(myString);	
			URLConnection hc = url.openConnection();	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;	
			BufferedReader buff = new BufferedReader(mystream);	
			String line = buff.readLine();
	
	
	
	
			while (line != null && priceStr.equals("no price available")) {

				if (line.contains("price")){
		
					int index = line.indexOf("price");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
			
					priceStr = line.substring(start + 1, decimal + 5);
					price = Double.parseDouble(priceStr);					

					
				}

		line = buff.readLine();

			}
	}
	
	catch (MalformedURLException e) {
		   System.err.println("Connection error. Please restart the program.");
	}
	
	catch (IOException e) {
		
		e.printStackTrace();
	}
	
	try {
		
		Thread.sleep(2 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
	return price;
		
		
	}


}