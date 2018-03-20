import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FinancialRSI extends FinancialObject {

	public FinancialRSI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void compareValues() {
		
		double RSI = 0.0;
		
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=RSI&symbol=" + symbol + "&interval=15min&time_period=10&series_type=close" + endString;
		
		try {
			
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String strRSI = "no price available";
	
			line = buff.readLine();
	
	
	
			while (line != null &&  RSI == 0) {

				if (line.contains("\"RSI\"")){
		
					int index = line.indexOf("\"RSI\"");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
								strRSI = line.substring(start + 1, decimal + 5);
					RSI = Double.parseDouble(strRSI);
					
					
					System.out.println("");	
					System.out.println("RSI for " + symbol + " is " + RSI + "\n");
					System.out.println("-------------------------------------------------------------------");
					
					if (RSI > 70) {
						System.out.println("RSI for " + symbol + " is now overbought. It is currently: " + RSI + ". Consider selling.");
					}
						if ( RSI < 30) {
							
							System.out.println("RSI for " + symbol + " is now oversold. It is currently: " + RSI + ". Consider buying.");
							
						}
					
				}
			
	
		line = buff.readLine();

			}
	
	
	}
	
	catch (MalformedURLException e) {
		   System.err.println("Malformed URL exception, please restart the program.");
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
		// TODO Auto-generated method stub
		
	}

}
