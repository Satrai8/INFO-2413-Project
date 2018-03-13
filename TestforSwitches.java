import java.util.*;


public class TestforSwitches {

	public static void main(String[] args) {
		
		
		// This is the ArrayList we create to store the objects for comparing at the end 
		ArrayList<FinancialObject> objects = new ArrayList<FinancialObject>();
		int numberOfObjects = 0;
		
		
		String marketChoice;
		Scanner input = new Scanner(System.in);
		
		
		do {
		
		System.out.println("Please enter a number market choice: ");
		System.out.println("1: Crypto");
		System.out.println("2: NYSE");
		System.out.println("3: Quit");
		

		marketChoice = input.next();


		if (marketChoice.equals("1")) {
			
			System.out.println("Please enter a trading rule: ");
			System.out.println("1: Volume increase/decrease");
			System.out.println("2: Percentage increase/decrease");
			
			String cryptoRuleChoice = input.next();
	
			
			switch (cryptoRuleChoice) {
			
			case "1":
				
				
				CryptoVolume ob = new CryptoVolume();
				ob.setMarket("Crypto");
				System.out.println("Please enter the crypto symbol");
				String symbolChoice = input.next();
				ob.setSymbol(symbolChoice);
				System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
				double percentageChoice = input.nextDouble();
				ob.setPercentage(percentageChoice);
				ob.setInitialValues();
				objects.add(ob);
				numberOfObjects ++;
				break;
				
			
			case "2":
				
				//works about half the time, other half returns "invalid API call" 
				CryptoPrice ob2 = new CryptoPrice();
				ob2.setMarket("Crypto");
				System.out.println("Please enter the crypto symbol");
				String symbolChoice2 = input.next();
				ob2.setSymbol(symbolChoice2);
				System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
				double percentageChoice2 = input.nextDouble();
				ob2.setPercentage(percentageChoice2);
				ob2.setInitialValues();
				objects.add(ob2);
				numberOfObjects ++;
				break;
				
				
			}
}
	
		
		else if (marketChoice.equals("2")) {
			
			System.out.println("Please enter a trading rule: ");
			System.out.println("1: Volume increase/decrease");
			System.out.println("2: Percentage increase/decrease");
			
			String nyseRuleChoice = input.next();
		
		switch (nyseRuleChoice) {
		
		case "1":
			
			// create the object
			FinancialVolume ob3 = new FinancialVolume();
			// set the market, though this isn't actually used anywhere so can probably remove
			ob3.setMarket("NYSE");
			System.out.print("Please enter 3 letter ticker symbol");
			// get the ticker symbol and then set it through method below
			String symbolChoice3 = input.next();
			ob3.setSymbol(symbolChoice3);
			System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
			
			// set percentage using method that converts input into usable value
			double percentageChoice3 = input.nextDouble();
			ob3.setPercentage(percentageChoice3);
			// call setInitialValues() to get the base price and the target
			ob3.setInitialValues();
			// add the object to our ArrayList
			objects.add(ob3);
			//increase number of objects so that we know how many are in our ArrayList for looping purposes
			numberOfObjects ++;
			break;
			
			
			
			
		case "2":
			
			FinancialPrice ob4 = new FinancialPrice();
			ob4.setMarket("NYSE");
			System.out.println("Please enter 3 letter ticker symbol");
			String symbolChoice4 = input.next();
			ob4.setSymbol(symbolChoice4);
			System.out.print("Please enter percentage increase/decrease i.e. 10%, -10%");
			double percentageChoice4 = input.nextDouble();
			ob4.setPercentage(percentageChoice4);
			ob4.setInitialValues();
			objects.add(ob4);
			numberOfObjects ++;
			break;
			
		} 
		
		
		// breaks out of switches if the user enters 3 (quit)
	} } while (!marketChoice.equals("3"));
		
		// run this loop forever since we're done with user input and the program is just executing the comparisons at this point in time
         while (true ) {
		
        	 // used for looping through our arrayList
		 for(int i = 0; i < numberOfObjects; i++)
		    {
		    
			 // gets the object at index position i and calls compare values on it
			 objects.get(i).compareValues();
		        
		     
		    }
         }
		

}
		
	}
