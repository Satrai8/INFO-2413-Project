import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FinancialVolume extends FinancialObject {
	
	double initialVolume;
	double currentVolume;
	double percentage;
	double targetVolume;
	
	
	public void setPercentage(double myPercentage){
		percentage = myPercentage/100.00 + 1.00;
	}
	
	
	


	@Override
	public void compareValues() {
		
		
		
		
		
		
		
		
		
		
		
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + endString;

		

		
		




		
		
		
		
		 
		
	
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String currentVol = "no price available";
	
			line = buff.readLine();
	
	
	
			while (line != null) {
				
				
	
		
		
		

				if (line.contains("volume")){
		
					int index = line.indexOf("volume");
					int quotation = line.indexOf('\"',index +7);
					int start = quotation +1;
					int end = line.indexOf('\"', quotation +1);
			
					
					currentVol = line.substring(start, end);
					initialVolume = Double.parseDouble(currentVol);
					targetVolume = initialVolume * percentage ;
					
						
					System.out.println("Initial Volume for " + symbol + " is " + initialVolume + "\n");
					System.out.println("Current Volume is " + currentVol + "\n");
					System.out.println("Target volume is " + targetVolume + "\n");
					System.out.println("-------------------------------------------------------------------");
				
				
				
					
					
					
					
		
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
		
		Thread.sleep(2 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
	}





	@Override
	public void setInitialValues() {
		
		
		
		
		
		
		
		
		
		
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + endString;

		

		
		




		
		
		
		
		 
		
	
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String currentVol = "no price available";
	
			line = buff.readLine();
	
	
	
			while (line != null) {
				
				
	
		
		
		
				if (line.contains("volume")){
		
					int index = line.indexOf("volume");
					int quotation = line.indexOf('\"',index +7);
					int start = quotation +1;
					int end = line.indexOf('\"', quotation +1);
			
					
					currentVol = line.substring(start, end);
					initialVolume = Double.parseDouble(currentVol);
					targetVolume = initialVolume * percentage ;
					
						
			
					
				
				
					
					
					
					
		
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
		
		Thread.sleep(2 * 1000);
	
	} catch (InterruptedException e1) {
		
		e1.printStackTrace();
	}
	
		

}
	
}
