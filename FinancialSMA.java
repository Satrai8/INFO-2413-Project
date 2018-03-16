import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FinancialSMA extends FinancialObject {
	
	boolean initializeSt = false;
	
	

	public FinancialSMA() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setStVal() {
		
		// used for breaking the loop once currentValue is set. We only run the loop once internally because it needs to move on to the next object in the array. The array will eventually loop back to the first object and call this entire method again.
				double currentShortTerm = 0.0;	
				
				symbol = "AMZN";
				
				String myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=5&series_type=close&apikey=U7CEKTSD7MP0A660";
				
			
				
				// all this part is the same as setInitialValues() method
				try {
			
					URL url = new URL(myString);
			
					URLConnection hc = url.openConnection();
			
					InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;
			
					BufferedReader buff = new BufferedReader(myStream);
			
					String line = buff.readLine();
			
					String stSMA = "not initiated";
			
			
				
					while (line !=null && stSMA.equals("not initiated")) {
						
						// same idea as setInitialValue() method		
						if (line.contains("\"SMA\"")){
				
							int index = line.indexOf("\"SMA\"");
							int decimal = line.indexOf(".",index);
							int start = decimal;
					
							while (line.charAt(start) != '\"')
							start --;
										stSMA = line.substring(start + 1, decimal + 5);
							currentShortTerm = Double.parseDouble(stSMA);
							
							
							
							
							if (consoleView) {
								
								System.out.println("The current simple short term moving average is " + currentShortTerm);
							
							}
														
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
			
			
			// used for breaking the loop once currentValue is set. We only run the loop once internally because it needs to move on to the next object in the array. The array will eventually loop back to the first object and call this entire method again.
					double currentLongTerm = 0.0;	
					
					
					
					 myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=60&series_type=close&apikey=U7CEKTSD7MP0A660";
					
				
					
					// all this part is the same as setInitialValues() method
					try {
				
						URL url = new URL(myString);
				
						URLConnection hc = url.openConnection();
				
						InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;
				
						BufferedReader buff = new BufferedReader(myStream);
				
						String line = buff.readLine();
				
						String ltSMA = "not initiated";
				
				
					
						while (line !=null && ltSMA.equals("not initiated")) {
							
			
							if (line.contains("\"SMA\"")){
					
								int index = line.indexOf("\"SMA\"");
								int decimal = line.indexOf(".",index);
								int start = decimal;
						
								while (line.charAt(start) != '\"')
								start --;
											ltSMA = line.substring(start + 1, decimal + 5);
								currentLongTerm = Double.parseDouble(ltSMA);
								
							
								
								
								if (consoleView) {
									
									
									System.out.println("The current simple long term moving average is " + currentLongTerm);
								
								}
					
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
				
				
				System.out.println("Made it this far and " + currentShortTerm + " " + currentLongTerm);
				
				if (currentShortTerm > currentLongTerm) {
					initializeSt = true;
				}
		
		
		
		
	}
	

	@Override
	public void compareValues() {
		
		
		// used for breaking the loop once currentValue is set. We only run the loop once internally because it needs to move on to the next object in the array. The array will eventually loop back to the first object and call this entire method again.
		double currentShortTerm = 0.0;	
		
		symbol = "AMZN";
		
		String myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=5&series_type=close&apikey=U7CEKTSD7MP0A660";
		
	
		
		// all this part is the same as setInitialValues() method
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(myStream);
	
			String line = buff.readLine();
	
			String stSMA = "not initiated";
	
	
		
			while (line !=null && stSMA.equals("not initiated")) {
				
				// same idea as setInitialValue() method		
				if (line.contains("\"SMA\"")){
		
					int index = line.indexOf("\"SMA\"");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
								stSMA = line.substring(start + 1, decimal + 5);
					currentShortTerm = Double.parseDouble(stSMA);
					
					
					
					
					if (consoleView) {
						
						System.out.println("The current simple short term moving average is " + currentShortTerm);
					
					}
												
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
	
	
	// used for breaking the loop once currentValue is set. We only run the loop once internally because it needs to move on to the next object in the array. The array will eventually loop back to the first object and call this entire method again.
			double currentLongTerm = 0.0;	
			
			
			
			 myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=60&series_type=close&apikey=U7CEKTSD7MP0A660";
			
		
			
			// all this part is the same as setInitialValues() method
			try {
		
				URL url = new URL(myString);
		
				URLConnection hc = url.openConnection();
		
				InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;
		
				BufferedReader buff = new BufferedReader(myStream);
		
				String line = buff.readLine();
		
				String ltSMA = "not initiated";
		
		
			
				while (line !=null && ltSMA.equals("not initiated")) {
					
	
					if (line.contains("\"SMA\"")){
			
						int index = line.indexOf("\"SMA\"");
						int decimal = line.indexOf(".",index);
						int start = decimal;
				
						while (line.charAt(start) != '\"')
						start --;
									ltSMA = line.substring(start + 1, decimal + 5);
						currentLongTerm = Double.parseDouble(ltSMA);
						
					
						
						
						if (consoleView) {
							
							
							System.out.println("The current simple long term moving average is " + currentLongTerm);
						
						}
			
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
		
		
		System.out.println("Made it this far and " + currentShortTerm + " " + currentLongTerm);
		
		
		
		if (initializeSt) {
			
			if (currentShortTerm < currentLongTerm)
				
				System.out.println("Short term moving average for" + symbol + "has exceeded long term moving average");
			
			
			
		}
		
		else {
			if (currentShortTerm > currentLongTerm)
				
				System.out.println("Short term moving average for" + symbol + "has exceeded long term moving average");
		}
		
		
		
	
		// Assume ST < LT to start
		if (currentShortTerm > currentLongTerm)
			
			System.out.println("Short term moving average for" + symbol + "has exceeded long term moving average");
		
		// Assume ST > LT to start
		if (currentShortTerm < currentLongTerm)
			
			System.out.println("Short term moving average for" + symbol + "has exceeded long term moving average");
			
			
			
			
			
			
			
	
	
	
	
	
    }
	
	
	
		
	

	@Override
	public void setInitialValues() {
		// TODO Auto-generated method stub
		
	}

}
