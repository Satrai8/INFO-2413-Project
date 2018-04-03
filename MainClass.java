///////////////////////////////////////////////////////////////////
//                                                               //
//   Armadillo 4000 was created by Zack Cockle, Sean Dunbar,     //
//   Juergen Kriz, Ryan Mock, and Sunveer Sandhu for INFO 2413   //
//   at Kwantlen Polytechnic University during the Spring 2018   //
//   semester.                                                   //
//                                                               //
///////////////////////////////////////////////////////////////////


import java.util.*;

public class MainClass {

    public static void main(String[] args)throws Exception {

	// Holds financial objects for sequential evaluation
        @SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<FinancialObject> objects = new ArrayList();


	Scanner input = new Scanner(System.in);
        char continueLoop = 'Y';                    // Controls 'do while' loop for returning to main menu
        char menuChoice;                            // Holds Main Menu user selection
        char stockChoice;                           // Holds Monitor Options menu user selection
        String symbol;                              // Holds stock ticker symbol String value input by user
        double percentIncrease = 0;                 // Holds percentIncrease value as double after conversion from String
        double percentDecrease = 0;                 // Holds percentDecrease value as double after conversion from String
        char changeAlertChoice;                     // Controls 'do while' loop for reentering percent increase/decrease values
        int numberOfObjects = 0;                    // Counts number of objects created
        int rsiLength = 0;                          // Holds Relative Simple Index length input by user in days
        int smaShortTerm = 0;                       // Holds short-term Simple Moving Average length input by user in days
        int smaLongTerm = 0;                        // Holds long-term Simple Moving Average length input by user in days
        char displayChoice;                         // Controls whether financial data is continuously displayed
        boolean validNumber = true;					
        boolean validTimePeriod = true;				



        UserInterface.displaySplashScreen();

        do {
            do {
                UserInterface.displayMainMenu();		
                menuChoice = input.next().charAt(0);
                if (menuChoice != '1' & menuChoice != '2' & menuChoice != '3' & menuChoice != '4') {		
                    UserInterface.displayMainMenuInputError();
                }
            } while (menuChoice != '1' & menuChoice != '2' & menuChoice != '3' & menuChoice != '4');
            if (menuChoice == '1' || menuChoice == '2') {
                if (menuChoice == '1') {
                    do {
                        UserInterface.displayMonitorOptionsMenu();
                        stockChoice = input.next().charAt(0);
                        if (stockChoice != '1' & stockChoice != '2' & stockChoice != '3') {
                            UserInterface.displayMonitorOptionsMenuInputError();
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
                            UserInterface.requestStockSymbolInput();
                            symbol = input.next().toUpperCase();
                            UserInterface.displayWaitTimeMessage();
                            if (ob4.validateCallSymbol(symbol))				// if user input generates valid API call, break out of loop
                                break;
                            else
                                UserInterface.displayInvalidStockSymbolError(); // display error and keep user in loop until valid symbol is input 
                        }
                        ob4.setSymbol(symbol);						
                        System.out.printf("                                      The current price of " + symbol + " is US $%.2f%n",ob4.getPrice());
                        do {
                            do {
                                validNumber = true;
                                System.out.println();
                                System.out.println("                                      Enter a percent INCREASE. A notification");
                                System.out.println("                                      will be displayed when the value of " + symbol);
                                System.out.print("                                      increases by this amount: ");
                                if (!input.hasNextDouble()) {				// force user input to be a double
                                    input.next();
                                    UserInterface.displayPercentIncreaseInputError();
                                    validNumber = false;					// validNumber is false while user input is not a double
                                }
                                if (validNumber) { 
                                    percentIncrease = input.nextDouble();
                                    if (percentIncrease <= 0) {				// force user input to input a positive number
                                        UserInterface.displayPercentIncreaseInputError();
                                    }
                                }
                            } while (!validNumber || percentIncrease <= 0);
                            ob4.setPercentage(percentIncrease);				// set percentIncrease only after all conditions are satisfied
                            do {
                                validNumber = true;
                                System.out.println();
                                System.out.println("                                      Enter a percent DECREASE. A notification");
                                System.out.println("                                      will be displayed when the value of " + symbol);
                                System.out.print("                                      decreases by this amount: ");
                                if (!input.hasNextDouble()) {
                                    input.next();
                                    UserInterface.displayPercentDecreaseInputError();
                                    validNumber = false;
                                }
                                if (validNumber) {
                                    percentDecrease = input.nextDouble();
                                    if (!validNumber || percentDecrease <= 0 || percentDecrease > 100) {	
                                        UserInterface.displayPercentDecreaseInputError();
                                    }
                                }
                            } while (percentDecrease <= 0 || percentDecrease > 100);
                            UserInterface.displayWaitTimeMessage();
                            percentDecrease *= -1;
                            ob4.setPercentage(percentDecrease);
                            ob4.setInitialValues();
                            System.out.println("                                      An alert will be displayed when the");
                            System.out.printf("                                      price of " + symbol + " increases to US $%.2f%n",ob4.getHighTarget());
                            System.out.printf("                                      or decreases to US $%.2f%n",ob4.getLowTarget());
                            do {
                                UserInterface.displayAlertChangeOption();
                                changeAlertChoice = Character.toUpperCase(input.next().charAt(0));
                                System.out.println();
                                if (changeAlertChoice != 'Y' && changeAlertChoice != 'N') {
                                    UserInterface.displayReturnOrMonitorOptionInputError();
                                }
                            } while (changeAlertChoice != 'Y' && changeAlertChoice != 'N');
                        } while (changeAlertChoice == 'N');
                        objects.add(ob4);								//add the completed object to the array
                        numberOfObjects ++;								// increase counter for number of objects array holds
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
                            UserInterface.requestStockSymbolInput();
                            symbol = input.next().toUpperCase();
                            UserInterface.displayWaitTimeMessage();
                            if (ob3.validateCallSymbol(symbol))
                                break;
                            else
                                UserInterface.displayInvalidStockSymbolError();
                        }
                        ob3.setSymbol(symbol);
                        do {
                            validTimePeriod = true;
	                    validNumber = true;
                            UserInterface.requestRSIPeriodInput();
                            if (!input.hasNextInt()) {					// require user input for RSI time period to be an integer
                                input.next();
                                UserInterface.displayInputTypeError();
                                validNumber = false;
                            }
                            if (validNumber) {
                                rsiLength = input.nextInt();
                                UserInterface.displayWaitTimeMessage();
                                if (!ob3.validateCallTimePeriod(rsiLength)) {	//check that API call allows this value
                                    validTimePeriod = false;
                                    UserInterface.displayRSIPeriodInputError();
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
                            UserInterface.requestStockSymbolInput();
                            symbol = input.next().toUpperCase();
                            UserInterface.displayWaitTimeMessage();
                            if (ob5.validateCallSymbol(symbol))
                                break;
                            else
                                UserInterface.displayInvalidStockSymbolError();
                        }
                        ob5.setSymbol(symbol);
                        do {
                            do {
                                validNumber = true;
                                validTimePeriod = true;
                                UserInterface.requestSMAShortPeriodInput();
                                if (!input.hasNextInt()) {
                                    input.next();
                                    UserInterface.displayInputTypeError();
                                    validNumber = false;
                                }
                                if (validNumber) {
                                    smaShortTerm = input.nextInt();
                                    UserInterface.displayWaitTimeMessage();
                                    if (!ob5.validateCallTimePeriod(smaShortTerm)) {
                                        UserInterface.displaySMAPeriodLengthInputError();
                                        validTimePeriod = false;
                                    }
                                }
                            } while (!validNumber || !validTimePeriod);				//force users to enter input again until input is able to generate valid API call
                            ob5.setSMAShortTerm(smaShortTerm);
                            do {
                                validNumber = true;
                                validTimePeriod = true;
                                UserInterface.requestSMALongPeriodInput();
                                if (!input.hasNextInt()) {
                                    input.next();
                                    UserInterface.displayInputTypeError();
                                    validNumber = false;
                                }
                                if (validNumber) {
                                    smaLongTerm = input.nextInt();
                                    UserInterface.displayWaitTimeMessage();
                                    if (!ob5.validateCallTimePeriod(smaLongTerm)) {
                                        UserInterface.displaySMAPeriodLengthInputError();
                                        validTimePeriod = false;
                                    }
                                }
                            } while (!validNumber || !validTimePeriod);
                            if (smaShortTerm >= smaLongTerm) {
                                UserInterface.displaySMAPeriodOrderInputError();
                                validTimePeriod = false;
                            }
                        } while (smaShortTerm >= smaLongTerm);
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
                        UserInterface.requestCryptocurrencySymbolInput();
            		symbol = input.next().toUpperCase();
                        UserInterface.displayWaitTimeMessage();
            		if (ob2.validateCallSymbol(symbol))
                            break;
         		else
                           UserInterface.displayCryptocurrencySymbolInputError();
                    }
                    ob2.setMarket("Crypto");
                    ob2.setSymbol(symbol);
                    System.out.printf("                                      The current price of " + symbol + " is US $%.2f%n",ob2.getPrice());
                    do {
                        do {
                            validNumber = true;
                            System.out.println();
                            System.out.println("                                      Enter a percent INCREASE. A notification");
                            System.out.println("                                      will be displayed when the value of " + symbol);
                            System.out.print("                                      increases by this amount: ");
                            if (!input.hasNextDouble()) {
                                input.next();
                                UserInterface.displayPercentIncreaseInputError();
                                validNumber = false;
                            }
                            if (validNumber) { 
                                percentIncrease = input.nextDouble();
                                if (percentIncrease <= 0) {
                                    UserInterface.displayPercentIncreaseInputError();
                                }
                            }
                        } while (!validNumber || percentIncrease <= 0);
                        ob2.setPercentage(percentIncrease);
                        do {
                            validNumber = true;
                            System.out.println();
                            System.out.println("                                      Enter a percent DECREASE. A notification");
                            System.out.println("                                      will be displayed when the value of " + symbol);
                            System.out.print("                                      decreases by this amount: ");
                            if (!input.hasNextDouble()) {
                                input.next();
                                UserInterface.displayPercentDecreaseInputError();
                                validNumber = false;
                            }
                            if (validNumber) {
                                percentDecrease = input.nextDouble();
                                if (percentDecrease <= 0 || percentDecrease > 100) {
                                    UserInterface.displayPercentDecreaseInputError();
                                }
                            }
                        } while (!validNumber || percentDecrease <= 0 || percentDecrease > 100);
                        UserInterface.displayWaitTimeMessage();
                        ob2.setPercentage(percentIncrease);
                        percentDecrease *= -1;
                        ob2.setPercentage(percentDecrease);
                        ob2.setInitialValues();
                        System.out.println("                                      An alert will be displayed when the");
                        System.out.printf("                                      price of " + symbol + " increases to US $%.2f%n",ob2.getHighTarget());
                        System.out.printf("                                      or decreases to US $%.2f%n",ob2.getLowTarget());
                        do {
                            UserInterface.displayAlertChangeOption();
                            changeAlertChoice = Character.toUpperCase(input.next().charAt(0));
                            System.out.println();
                            if (changeAlertChoice != 'Y' && changeAlertChoice != 'N') {
                                UserInterface.displayReturnOrMonitorOptionInputError();
                            }
                        } while (changeAlertChoice != 'Y' && changeAlertChoice != 'N');
                    } while (changeAlertChoice == 'N');
                    objects.add(ob2);
                    numberOfObjects ++;
                }

                UserInterface.displayConfigurationComplete();
                do {
                    UserInterface.displayReturnOrMonitorOption();
                    continueLoop = Character.toUpperCase(input.next().charAt(0));
                    if (continueLoop != 'Y' && continueLoop != 'N') {
                        System.out.println();
                        UserInterface.displayReturnOrMonitorOptionInputError();
                    }
                } while (continueLoop != 'Y' && continueLoop != 'N');
            }

            else if (menuChoice == '3') {
                UserInterface.displayAboutScreen();
                continueLoop = 'Y';
            }

            else if (menuChoice == '4') {
                UserInterface.displayExitMessage();
                Thread.sleep(3500);
                System.exit(0);
            }
        } while (continueLoop == 'Y');

            do {
                UserInterface.displayRealtimeMonitorOption();
                displayChoice = Character.toUpperCase(input.next().charAt(0));
                System.out.println();
                if (displayChoice != 'Y' && displayChoice != 'N') {
                    UserInterface.displayReturnOrMonitorOptionInputError();
                }
            } while (displayChoice != 'Y' && displayChoice != 'N');

        UserInterface.displayMonitoringInitiatedConfirmation();
	input.close();


        /////////////////////////////////////////////////////
        //                                                 //
        //   Accesses the 'objects' ArrayList to display   //
        //   financial data for previously configured      //
        //   objects as they are monitored                 //
        //                                                 //
        /////////////////////////////////////////////////////

        while(true) {
            for(int i = 0; i < numberOfObjects; i++) {
		if(Character.toUpperCase(displayChoice) == 'Y') {
                    objects.get(i).setConsoleInput(1);
                }
		objects.get(i).compareValues();						// Run compare values on each object in the array continuously
            }
        }
    }
}