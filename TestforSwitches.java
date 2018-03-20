import java.util.*;


public class TestforSwitches {

	public static void main(String[] args)throws Exception {
		

		ArrayList<FinancialObject> objects = new ArrayList<FinancialObject>();
		int numberOfObjects = 0;
		
		
		String marketChoice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to view output in the console while the program is running?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		
		int consoleInputChoice = input.nextInt();
		

		do {
		
		System.out.println("Please enter your choice below: ");
		System.out.println("1 for CryptoCurrency");
		System.out.println("2 for NYSE");
		System.out.println("3 to Begin Monitoring");
		

		marketChoice = input.next();


		if (marketChoice.equals("1")) {
			
			CryptoPrice ob2 = new CryptoPrice();
			ob2.setMarket("Crypto");
			System.out.println("Please enter the CryptoCurrency symbol: ");
			ob2.setSymbol(input.next());
			System.out.println("Please enter a percentage increase/decrease i.e. 10, -10: \n");
			ob2.setPercentage(input.nextDouble());
			ob2.setInitialValues();
			objects.add(ob2);
			numberOfObjects ++;
	
			
}
	
		
		else if (marketChoice.equals("2")) {
			
			System.out.println("Please enter a trading rule: ");
			
			System.out.println("1: RSI");
			System.out.println("2: Percentage increase/decrease");
			System.out.println("3: SMA");
			
			String nyseRuleChoice = input.next();
		
		switch (nyseRuleChoice) {
		
		case "1":
			
			
			FinancialRSI ob3 = new FinancialRSI();
			System.out.print("Please enter a stock ticker symbol: ");
			ob3.setSymbol(input.next());	
			objects.add(ob3);
			numberOfObjects ++;
			break;
						
		case "2":
			
			FinancialPrice ob4 = new FinancialPrice();
			ob4.setMarket("NYSE");
			System.out.println("Please enter a stock ticker symbol: ");
			ob4.setSymbol(input.next());
			System.out.print("Please enter a percentage increase/decrease i.e. 10, -10: \n");
			ob4.setPercentage(input.nextDouble());
			ob4.setInitialValues();
			objects.add(ob4);
			numberOfObjects ++;
			break;
			
		case "3":
			
			FinancialSMA ob5 = new FinancialSMA();
			System.out.println("Please enter a stock ticker symbol: ");
			ob5.setSymbol(input.next());
			ob5.setinitializeSt();
			objects.add(ob5);
			numberOfObjects ++;
			break;
			
		} 
		
	
		
		// breaks out of switches if the user enters 3 (quit)
	} } while (!marketChoice.equals("3"));
		

	input.close();

		
		// run this loop forever since we're done with user input and the program is just executing the comparisons at this point in time
         while (true ) {
		
        	 // used for looping through our arrayList
		 for(int i = 0; i < numberOfObjects; i++)
		    {
		    
			 // gets the object at index position i and calls compare values on it
			 if (consoleInputChoice == 1){
				 objects.get(i).setConsoleInput(consoleInputChoice);				 
			 }
			 objects.get(i).compareValues();
		        
		     
		    }
         }
		

}
		
	}