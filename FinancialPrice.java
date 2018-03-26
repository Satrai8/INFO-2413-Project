import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



public class FinancialPrice extends FinancialObject {
	
	// the fields we need for this class in particular. Symbol(ex. AMZN) and Market(ex. NYSE) are inherited through superclass so not used directly here.
	
	double positivePercentage;
	double negativePercentage;
	double initialValue;
	double highTarget;
	double lowTarget;
	
	
	// default constructor for making the object
	public FinancialPrice() {
		
	}
	
	
	// used for setting the percentage from user input and converting it to a value we can use for the math. Will work with negatives too (ex. -5/100 + 1.0 = 0.95)
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
	
	
	// overrides empty setInitialValues() method from superclass
	@Override
	public void setInitialValues() {
				
		// our API key
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		// the actual API query URL. Notice symbol is plugged in as a variable (ex. BTC) and this will come from user input executing in the TestforSwitches Class where the main code is running
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + endString;
		
		
		// setting initial value here, this will allow us to break the loop below when initial value obtains a value from the API call
		initialValue = -1.00;
		
	
		try {
	
			//creates the URL object using myString that we created above using user input and our API key.
			URL url = new URL(myString);
	
			//opens the link/connection to the above URL object created.
			URLConnection hc = url.openConnection();
	
			// open a stream reader on the above connection ( to read the data returned by the API calls line by line)
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
			
			//buffer the step above
			BufferedReader buff = new BufferedReader(mystream);
			
			// use readLine() method to read a new line of text from the API call return and assign it to string variable line
			String line = buff.readLine();
			
			// initialize price variable
			String price = "no price available";
	
			
	
	
			// loop will keep running while line isn't null and initial value is still defaulted to -1.00. Once we manage to parse an initialValue this loop will break out since we're done with it at that point.
			while (line != null && initialValue == -1.00) {
				
		// checks to see if the current line contains the word price
				if (line.contains("price")){
		
					// finds the index of the word price in that line, and sets the value to the integer variable called index
					int index = line.indexOf("price");
					
					// searches for the first occurrence of a decimal, starting from the index of the word price, which we assigned to the index variable. Creates a variable called decimal for this index.
					int decimal = line.indexOf(".",index);
					
					// assign a new variable as the start point because we're going to need to move it back from the decimal index in order to capture the numbers in front of the decimal
					int start = decimal;
			
					/* checks the character at the index of our start variable, if the character is not a quotation mark, it moves start index back by 1. Keeps going until it hits the next quotation mark. 
					 * At this point we know this is the beginning of the number we want to capture */
					 
					while (line.charAt(start) != '\"')
					start --;
			
					// this is where we actually get the price taking a substring of only what we want out of the entire line. The first index is start + 1 ( 1 more than the index of the quotation mark) and then we end 5 places from the decimal
					price = line.substring(start + 1, decimal + 5);
					
					// it's parsed as a string, so now we convert it to an integer so we can use it for math.
					initialValue = Double.parseDouble(price);
					
					// percentage is already sent properly in the main class where setPercentage is called, so our math works fine here to get target.
					highTarget = initialValue * positivePercentage;
					lowTarget = initialValue * negativePercentage;
											
				}
			
		// reads in the next line
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
	public void compareValues() {
		
		// used for breaking the loop once currentValue is set. We only run the loop once internally because it needs to move on to the next object in the array. The array will eventually loop back to the first object and call this entire method again.
		double currentVal = 0.0;		
		
		String endString ="&apikey=U7CEKTSD7MP0A660";
		
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + endString;
		
	
		
		// all this part is the same as setInitialValues() method
		try {
	
			URL url = new URL(myString);
	
			URLConnection hc = url.openConnection();
	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
	
			BufferedReader buff = new BufferedReader(mystream);
	
			String line = buff.readLine();
	
			String price = "no price available";
	
	
		
			while (line != null && currentVal == 0.0) {
				
				// same idea as setInitialValue() method		
				if (line.contains("price")){
		
					int index = line.indexOf("price");
					int decimal = line.indexOf(".",index);
					int start = decimal;
			
					while (line.charAt(start) != '\"')
					start --;
			
					price = line.substring(start + 1, decimal + 5);
					currentVal = Double.parseDouble(price);
					
					
					if (consoleView) {
					System.out.println("\nCurrent value for " + symbol + " is " + currentVal + "\n");					
					System.out.printf("Upper target value is %.2f%n",highTarget);
					System.out.printf("Lower target value is %.2f%n",lowTarget);
					System.out.println("");
					System.out.println("Initial Value is " + initialValue + "\n");					
					System.out.println("-------------------------------------------------------------------");
					
					}
					
					
					
					
					
					
					if (positivePercentage > 1.0 && currentVal > highTarget) {
												
						System.out.println("****************  Your upper target price for " + symbol + " has been reached  ************************");					
						
						System.out.println("-------------------------------------------------------------------");
												
					}
					
					else if (negativePercentage < 1.0 && currentVal < lowTarget) {
					
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
	public boolean validateCall(String inputSymbol) throws IOException {
		symbol = inputSymbol;
		String str = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + "&apikey=U7CEKTSD7MP0A660";
		boolean valid = true;
		
		
		URL url = new URL(str);

		URLConnection hc = url.openConnection();

		InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;
		
		BufferedReader buff = new BufferedReader(mystream);
		
		String line = buff.readLine();
		
		while (line != null) {
						
			/* API call for BATCH_STOCK_QUOTES query never returns error even with wrong stock ticker input
			  we can only check for [] in output to see that an invalid or no input was used.
			 */
			if (line.contains("[]"))
				valid = false;
			
			line = buff.readLine();
		}
		return valid;
		
		
		
		
	}


	public double getPrice() {

		String endString ="&apikey=U7CEKTSD7MP0A660";		
		String myString = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbol + endString;
		String priceStr = "no price available";	
		double price = 0;
			
		try {
	
			URL url = new URL(myString);	
			URLConnection hc = url.openConnection();	
			InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;			
			BufferedReader buff = new BufferedReader(mystream);			
			String line = buff.readLine();			
						
			while (line != null && priceStr.equals("no price available"))  {
				
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