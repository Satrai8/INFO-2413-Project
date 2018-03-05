import java.util.*;


public class TestforSwitches {

	public static void main(String[] args) {
		
		CryptoPrice crypto = new CryptoPrice();
		crypto.setInitialValues();
		System.out.println();
		
		
		ArrayList<FinancialObject> objects = new ArrayList<FinancialObject>();
		int numberOfObjects = 0;
		
		
		
		Scanner input = new Scanner(System.in);
		String marketChoice = null;
		
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
				
				// template only, this one hasn't been finished yet, currently just a copy of the price rule
				CryptoPrice ob = new CryptoPrice();
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
				
				
			}
}
	
		
		else if (marketChoice.equals("2")) {
			
			System.out.println("Please enter a trading rule: ");
			System.out.println("1: Volume increase/decrease");
			System.out.println("2: Percentage increase/decrease");
			
			String nyseRuleChoice = input.next();
		
		switch (nyseRuleChoice) {
		
		case "1":
			
			
			FinancialVolume ob3 = new FinancialVolume();
			ob3.setMarket("NYSE");
			System.out.print("Please enter 3 letter ticker symbol");
			String symbolChoice3 = input.next();
			ob3.setSymbol(symbolChoice3);
			System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
			double percentageChoice3 = input.nextDouble();
			ob3.setPercentage(percentageChoice3);
			ob3.setInitialValues();
			objects.add(ob3);
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
			
		} 
		
		
	} } while (!marketChoice.equals("3"));
		
         while (true ) {
		
		 for(int i = 0; i < numberOfObjects; i++)
		    {
		       // System.out.println(objects.get(i).market);
		      //  System.out.println(objects.get(i).symbol);
		       // System.out.println(objects.get(i).initialValue);
		      //  System.out.println(objects.get(i).target);
		        objects.get(i).compareValues();
		    }
         }
		

}
		
	}
