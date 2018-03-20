import java.io.*;
import java.util.*;


public class TestforSwitches {

	public static void main(String[] args)throws Exception {
		
		File file = new File("word.txt");
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		FileOutputStream output = new FileOutputStream(file);
		PrintWriter writer = new PrintWriter(output);
		
		String word = "Let me see if this shit works";
		writer.write(word);
		writer.flush();
		output.close();
		writer.close();
		
		
		// This is the ArrayList we create to store the objects for comparing at the end 
		ArrayList<FinancialObject> objects = new ArrayList<FinancialObject>();
		int numberOfObjects = 0;
		
		
		String marketChoice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to view output in the console while the program is running?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		
		int consoleInputChoice = input.nextInt();
		
		
		
		
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
				ob.setSymbol(input.next());
				System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
				ob.setPercentage(input.nextDouble());
				ob.setInitialValues();
				objects.add(ob);
				numberOfObjects ++;
				break;
				
			
			case "2":
				
				//works about half the time, other half returns "invalid API call" 
				CryptoPrice ob2 = new CryptoPrice();
				ob2.setMarket("Crypto");
				System.out.println("Please enter the crypto symbol");
				ob2.setSymbol(input.next());
				System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");
				ob2.setPercentage(input.nextDouble());
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
			System.out.println("3: SMA");
			
			String nyseRuleChoice = input.next();
		
		switch (nyseRuleChoice) {
		
		case "1":
			
			// create the object
			FinancialVolume ob3 = new FinancialVolume();
			// set the market, though this isn't actually used anywhere so can probably remove
			ob3.setMarket("NYSE");
			System.out.print("Please enter 3 letter ticker symbol");
			// get the ticker symbol and then set it through method below
			ob3.setSymbol(input.next());
			System.out.println("Please enter a percentage increase/decrease i.e. 10%, -10%");			
			// set percentage using method that converts input into usable value
			ob3.setPercentage(input.nextDouble());
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
			ob4.setSymbol(input.next());
			System.out.print("Please enter percentage increase/decrease i.e. 10%, -10%");
			ob4.setPercentage(input.nextDouble());
			ob4.setInitialValues();
			objects.add(ob4);
			numberOfObjects ++;
			break;
			
		case "3":
			
			FinancialSMA ob5 = new FinancialSMA();
			System.out.println("Please enter 3 letter ticker symbol");
			ob5.setSymbol(input.next());
			ob5.setinitializeSt();
			objects.add(ob5);
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
			 if (consoleInputChoice == 1){
				 objects.get(i).setConsoleInput(consoleInputChoice);				 
			 }
			 objects.get(i).compareValues();
		        
		     
		    }
         }
		

}
		
	}