
// cd Documents\NetBeansProjects\Armadillo4000\build\classes
// java -cp . MainClass

///////////////////////////////////////////////////////////////////
//                                                               //
//   Armadillo 4000 was created by Zack Cockle, Sean Dunbar,     //
//   Juergen Kriz, Ryan Mock, and Sunny Sunveer for INFO 2413    //
//   at Kwantlen Polytechnic University during the Spring 2018   // 
//   semester.                                                   //
//                                                               //
///////////////////////////////////////////////////////////////////


import java.util.*;

public class MainClass {

    public static void main(String[] args)throws Exception {

	// Holds financial objects for sequential evaluation
        ArrayList<FinancialObject> objects = new ArrayList();


	Scanner input = new Scanner(System.in);
        char continueLoop = 'Y';                    // Controls 'do while' loop for returning to main menu
        char menuChoice;                            // Holds Main Menu user selection
        char stockChoice;                           // Holds Monitor Options menu user selection
	String symbol;                              // Holds stock ticker symbol String value input by user
        String percentIncreaseString;               // Temporarily holds the string value of percentIncrease user input
        double percentIncrease = 0;                     // Holds precentIncrease value as double after conversion from String
        String percentDecreaseString;               // Temporarily holds the string value of percentDecrease user input
        double percentDecrease = 0;                     // Holds precentDecrease value as double after conversion from String
	int numberOfObjects = 0;                    // Counts number of objects created
        int rsiLength = 0;                              // Holds Relative Simple Index length input by user in days
        int smaShortTerm = 0;                           // Holds short-term Simple Moving Average length input by user in days
        int smaLongTerm = 0;                            // Holds long-term Simple Moving Average length input by user in days
        char displayChoice;                         // Controls whether financial data is continuously displayed
        boolean validNumber = true;
        boolean validTimePeriod = true;
        
        
        UserInterface UI = new UserInterface();    // Creates user interface object for printing UI elements
        UI.printArmadilloLogo();       
       
        System.in.read();
        System.out.println();
        

        do {
            do {
                UI.printMenu();
                menuChoice = input.next().charAt(0);
                System.out.println();

                if (menuChoice != '1' & menuChoice != '2' & menuChoice != '3' & menuChoice != '4') {
                  
                	UI.menuError();
                }
            } while (menuChoice != '1' & menuChoice != '2' & menuChoice != '3' & menuChoice != '4');


         

            System.out.println();
            if (menuChoice == '1' || menuChoice == '2') {
                if (menuChoice == '1') {
                    do {
                    	
                        UI.printMonitor();
                        
                        stockChoice = input.next().charAt(0);
                        System.out.println();
                        System.out.println();

                        if (stockChoice != '1' & stockChoice != '2' & stockChoice != '3') {
                            
                        	UI.monitorError();
                        }
                    } while (stockChoice != '1' & stockChoice != '2' & stockChoice != '3');


                    ///////////////////////////////////////////////////////
                    //                                                   //
                    //   Creates a financial stock object monitored by   //
                    //   percent increase/decrease based on user input   //
                    //                                                   //
                    ///////////////////////////////////////////////////////

                    switch (stockChoice) {
                    case '1':
                        FinancialPrice ob4 = new FinancialPrice();
                        while (true) {
                        	
                            UI.printPriceMenu();
                            
                            symbol = input.next().toUpperCase();
                            if (ob4.validateCallSymbol(symbol))
                                break;
                            else
                                UI.priceSymbolError();
                        }
                        ob4.setSymbol(symbol);
                        System.out.println();
                        System.out.printf("                                      The current price of " + symbol + " is %.2f%n",ob4.getPrice());

                        do {
                        		validNumber = true;
                                System.out.println();
                            	System.out.println("                                      Enter a percent INCREASE. A notification");
                            	System.out.println("                                      will be displayed when the value of " + symbol);
                            	System.out.print("                                      increases by this amount: ");
                            	                           	                          	
                        
                            if (!input.hasNextDouble())
                            {
                            	input.next();
                            	
                            	UI.priceError();
                                validNumber = false;    
                                
                        	
                            }
                            
                           if (validNumber) { 
                        	   
                        	   percentIncrease = input.nextDouble();
                            
                        	   if (percentIncrease <= 0) 
                        	   {
                                UI.priceIncreaseError();
                            }
                           }
                            
                        } while (percentIncrease <= 0);
                        ob4.setPercentage(percentIncrease);
                        do {
                        	validNumber = true;
                            System.out.println();
                            System.out.println("                                      Enter a percent DECREASE. A notification");
                            System.out.println("                                      will be displayed when the value of " + symbol);
                            System.out.print("                                      decreases by this amount: ");

                            if (!input.hasNextDouble())
                            {
                            	input.next();
                            	
                            	UI.priceError();
                                validNumber = false;

                            }
                            
                            if (validNumber) {
                            	
                            	percentDecrease = input.nextDouble();
                            
                            	if (percentDecrease <= 0 || percentDecrease > 100) {
                            		UI.priceDecreaseError();
                            	}                            
                           }
                            
                        } while (percentDecrease <= 0 || percentDecrease > 100);
                        percentDecrease *= -1;
                        ob4.setPercentage(percentDecrease);
                        ob4.setInitialValues();
                        objects.add(ob4);
                        numberOfObjects ++;
                        break;


                        ///////////////////////////////////////////////////////
                        //                                                   //
                        //   Creates a financial stock object monitored by   //
                        //   Relative Strength Index based on user input     //
                        //                                                   //
                        ///////////////////////////////////////////////////////

                        case '2':
                            FinancialRSI ob3 = new FinancialRSI();
                            while (true) {
                                UI.printPriceMenu();
                                symbol = input.next().toUpperCase();
                                if (ob3.validateCallSymbol(symbol)) 
                                    break;
                                else
                                   UI.priceSymbolError();
                            }
                            ob3.setSymbol(symbol);
                           
						do {
							 	validTimePeriod = true;
	                            validNumber = true;
                                UI.timePeriodMenu();
                                
                                if (!input.hasNextInt())
                                {
                                	input.next();
                                	
                                	   UI.timePeriodError();
                                       validNumber = false;

                                }
                                
                                
                                if (validNumber) {
                                rsiLength = input.nextInt();
                                if (!ob3.validateCallTimePeriod(rsiLength)) 
                                {
                                	validTimePeriod = false;
                                   UI.timePeriodRangeError();
                                }                               
                                }
                            } while (!validTimePeriod || !validNumber);
                            
                            ob3.setTimePeriod(rsiLength);
                            objects.add(ob3);
                            numberOfObjects ++;
                            break;


                            ///////////////////////////////////////////////////////
                            //                                                   //
                            //   Creates a financial stock object monitored by   //
                            //   Simple Moving Average based on user input       //
                            //                                                   //
                            ///////////////////////////////////////////////////////

                            case '3':
                                FinancialSMA ob5 = new FinancialSMA();
                                while (true) {
                                    UI.printPriceMenu();
                                    symbol = input.next().toUpperCase();
                                    if (ob5.validateCallSymbol(symbol)) 
                                        break;
                                    else
                                        UI.priceSymbolError();
                                }
                                ob5.setSymbol(symbol);
 
                                do {
                                
                                	do {	
                                	
                                	validNumber = true;
                                	validTimePeriod = true;
                                    UI.shortTermSMA();                               
                                    
                                    if (!input.hasNextInt())
                                    {
                                    	input.next();
                                    	
                                    	   UI.timePeriodError();
                                           validNumber = false;

                                    }
                                  
                                    if (validNumber) {
                                    
                                    smaShortTerm = input.nextInt();
                                    
                                    if (!ob5.validateCallTimePeriod(smaShortTerm)) {
                                        UI.timePeriodShort();
                                        validTimePeriod = false;
                                    }
                                    
                                    }
                                } while (!validNumber || !validTimePeriod);
                                ob5.setSMAShortTerm(smaShortTerm);
                                do {
                                	
                                	validNumber = true;
                                	validTimePeriod = true;
                                	
                                	UI.longTermSMA();
                                    
                                    
                                    
                                    
                                    if (!input.hasNextInt())
                                    {
                                    	input.next();
                                    	
                                    	   UI.timePeriodError();
                                           validNumber = false;

                                    }
                                    
                                    if (validNumber) {
                                    smaLongTerm = input.nextInt();
                                    if (!ob5.validateCallTimePeriod(smaLongTerm)) {
                                        UI.timePeriodShort();
                                        validTimePeriod = false;
                                    }
                                    }
                                    
                                
                                } while (smaLongTerm <= 0);
                                } while (smaShortTerm >= smaLongTerm); //notification needed
                                ob5.setSMALongTerm(smaLongTerm);
                                ob5.setInitialValues();
                                objects.add(ob5);
                                numberOfObjects ++;
                    }
                }


                ///////////////////////////////////////////////////////
                //                                                   //
                //   Creates a crypto-currency object monitored by   //
                //   percent increase/decrease based on user input   //
                //                                                   //
                ///////////////////////////////////////////////////////

                else if (menuChoice == '2') {
                    CryptoPrice ob2 = new CryptoPrice();
                    while (true) {
                        UI.cryptoMenu();
            		symbol = input.next().toUpperCase();
            		if (ob2.validateCallSymbol(symbol)) 
                            break;
         		else
                           UI.cryptoBad();
                    }
                    ob2.setMarket("Crypto");
                    ob2.setSymbol(symbol);
                    System.out.println();
                    System.out.printf("                                      The current price of " + symbol + " is %.2f%n",ob2.getPrice());
                    do {
                		validNumber = true;
                        System.out.println();
                    	System.out.println("                                      Enter a percent INCREASE. A notification");
                    	System.out.println("                                      will be displayed when the value of " + symbol);
                    	System.out.print("                                      increases by this amount: ");
                    	                           	                          	

                        if (!input.hasNextDouble())
                        {
                        	input.next();
                        	
                        	UI.priceError();
                            validNumber = false;    
                            
                    	
                        }
                        
                        
                        if (validNumber) { 
                     	   
                     	   percentIncrease = input.nextDouble();
                         
                     	   if (percentIncrease <= 0) 
                     	   {
                             UI.priceIncreaseError();
                         }
                        }
                        
                        
                        
                    } while (percentIncrease <= 0);
                    ob2.setPercentage(percentIncrease);
                    do {
                    	validNumber = true;
                        System.out.println();
                        System.out.println("                                      Enter a percent DECREASE. A notification");
                        System.out.println("                                      will be displayed when the value of " + symbol);
                        System.out.print("                                      decreases by this amount: ");


                        if (!input.hasNextDouble())
                        {
                        	input.next();
                        	
                        	UI.priceError();
                            validNumber = false;    
                            
                    	
                        }
                        
                        
                        if (validNumber) {
                        	percentDecrease = input.nextDouble();
                        if (percentDecrease <= 0 || percentDecrease > 100) {
                            UI.priceDecreaseError();
                        }                        
                        }
                    } while (percentDecrease <= 0 || percentDecrease > 100);
                    ob2.setPercentage(percentIncrease);
                    percentDecrease *= -1;
                    ob2.setPercentage(percentDecrease);
                    ob2.setInitialValues();
                    objects.add(ob2);
                    numberOfObjects ++;
                }




                UI.configComplete();
                
                do {
                    UI.returnChoice();
                    continueLoop = Character.toUpperCase(input.next().charAt(0));
                    System.out.println();
                    if (continueLoop != 'Y' && continueLoop != 'N') {
                        UI.yesOrNo();
                    }
                } while (continueLoop != 'Y' && continueLoop != 'N');
            }




            else if (menuChoice == '3') {
                UI.aboutPage();
                System.in.read();
                continueLoop = 'Y';
            }




            else if (menuChoice == '4') {
                UI.exitPage();
                System.exit(0);
            }
        } while (continueLoop == 'Y');




                do {
                    UI.viewData();
                    displayChoice = Character.toUpperCase(input.next().charAt(0));
                    System.out.println();
                    if (displayChoice != 'Y' && displayChoice != 'N') {
                        UI.yesOrNo();
                    }
                } while (displayChoice != 'Y' && displayChoice != 'N');

	input.close();


        /////////////////////////////////////////////////////
        //                                                 //
        //   Accesses the 'objects' ArrayList to display   //
        //   financial data for previously configured      //
        //   objects as they are monitored                 //
        //                                                 //
        /////////////////////////////////////////////////////

        System.out.println();
        while(true) {
            for(int i = 0; i < numberOfObjects; i++) {
		if(Character.toUpperCase(displayChoice) == 'Y') {
                    objects.get(i).setConsoleInput(1);
                }
		objects.get(i).compareValues();
            }
        }
    }
}