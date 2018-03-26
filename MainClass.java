import java.util.*;

public class MainClass{

    public static void main(String[] args)throws Exception {

	ArrayList<FinancialObject> objects = new ArrayList<FinancialObject>();
	int numberOfObjects = 0;

	int menuChoice;
	String symbol;
	Scanner input = new Scanner(System.in);

        // Armadillo 4000 ASCII title courtesy http://www.patorjk.com/software/taag
        // ASCII art armadillo courtesy https://jmilor.startlogic.com/asciiart/ARMADILO.TXT
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *            _                             _ _ _ _         _  _    ___   ___   ___          *");
        System.out.println("     *           / \\   _ __ _ __ ___   __ _  __| (_) | | ___   | || |  / _ \\ / _ \\ / _ \\         *");
        System.out.println("     *          / _ \\ | '__| '_ ` _ \\ / _` |/ _` | | | |/ _ \\  | || |_| | | | | | | | | |        *");
        System.out.println("     *         / ___ \\| |  | | | | | | (_| | (_| | | | | (_) | |__   _| |_| | |_| | |_| |        *");
        System.out.println("     *        /_/   \\_\\_|  |_| |_| |_|\\__,_|\\__,_|_|_|_|\\___/     |_|  \\___/ \\___/ \\___/         *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                      ,:::://///,:::-.                                     *");
        System.out.println("     *                                     /:''/////// ``:::`;/|/                                *");
        System.out.println("     *                                    /'   ||||||     :://'`\\                                *");
        System.out.println("     *                                  .' ,   ||||||     `/(  e \\                               *");
        System.out.println("     *                            -===~__-'\\__X_`````\\_____/~`-._ `.                             *");
        System.out.println("     *                                        ~~        ~~       `~-'                            *");
        System.out.println("     *                                                                                           *");
        System.out.println("     *                                                                                           *");
        System.out.println("     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println();
        System.out.println("                                        Press enter to continue");
        System.in.read();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        char continueLoop = 'Y';
        while (Character.toUpperCase(continueLoop) == 'Y'){
            System.out.println("                                           M a i n   M e n u");
            System.out.println("                                      ---------------------------");
            System.out.println("                                      1 - Monitor a Stock on NYSE");
            System.out.println("                                      2 - Monitor a Cryptocurrency");
            System.out.println("                                      3 - About Armadillo 4000");
            System.out.println("                                      4 - Exit Program");
            System.out.println();
            System.out.println("                                      To make a selection, enter the");
            System.out.print("                                      corresponding number: ");
            while(!input.hasNextInt())
            {
            	input.next();
            	System.out.println("Invalid input.");
            	System.out.println("Please enter a number between 1-4: ");
            }
            menuChoice = input.nextInt();
            System.out.println();
            System.out.println();
            System.out.println();

            if (menuChoice == 1 || menuChoice == 2) {
                if (menuChoice == 1){
                    System.out.println("                                      M o n i t o r   O p t i o n s");
                    System.out.println("                                      -----------------------------");
                    System.out.println("                                      1 - Percent Increase/Decrease");
                    System.out.println("                                      2 - Relative Strength Index");
                    System.out.println("                                      3 - Simple Moving Average");
                    System.out.println();
                    System.out.println("                                      To make a selection, enter the");
                    System.out.print("                                      corresponding number: ");
                    while(!input.hasNextInt())
                    {
                    	input.next();
                    	System.out.println("Invalid input.");
                    	System.out.println("Please enter a number between 1-3: ");
                    }
                    int nyseRuleChoice = input.nextInt();
                    System.out.println();

                    switch (nyseRuleChoice){
                        case 1:
                        FinancialPrice ob4 = new FinancialPrice();
                        
                        while (true) {
                        	
                        	System.out.println("                                      Enter the ticker symbol of");
                            System.out.print("                                      the stock to be monitored: ");
                			symbol = input.next().toUpperCase();
                			if (ob4.validateCall(symbol)) 
                			break;
                			
                			else
                				
                                System.out.println();
                                System.out.println("                                         ! ! ! Invalid Stock Symbol ! ! !");
                                System.out.println("                                        Monitored stocks must be currently");
                                System.out.println("                                      traded on the New York Stock Exchange.");
                			}
                        
                        ob4.setSymbol(symbol);
                        System.out.printf("                                      The current price of " + symbol + " is %.2f%n",ob4.getPrice());
                        double percentIncrease = -1;
                        while (percentIncrease <= 0){
                            System.out.println();
                            System.out.println("                                      Enter a percent INCREASE. A notification");
                            System.out.println("                                      will be displayed when the value of " + symbol);
                            System.out.print("                                      increases by this amount: ");
                            percentIncrease = input.nextDouble();
                            if (percentIncrease <= 0){
                                System.out.println();
                                System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                                System.out.println("                                      Value must be greater than zero");
                            }
                        }
                        ob4.setPercentage(percentIncrease);
                        double percentDecrease = -1;
                        while (percentDecrease <= 0 || percentDecrease > 100){
                            System.out.println();
                            System.out.println("                                      Enter a percent DECREASE. A notification");
                            System.out.println("                                      will be displayed when the value of " + symbol);
                            System.out.print("                                      decreases by this amount: ");
                            percentDecrease = input.nextDouble();
                            if (percentDecrease <= 0){
                                System.out.println();
                                System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                                System.out.println("                                      Value must be greater than zero");
                            }
                            else if (percentDecrease > 100){
                                System.out.println();
                                System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                                System.out.println("                                        Value must be less than 100");
                            }
                        }
                        percentDecrease *= -1;
                        ob4.setPercentage(percentDecrease);
                        ob4.setInitialValues();
                        objects.add(ob4);
                        numberOfObjects ++;
                        break;

                        case 2:
                        FinancialRSI ob3 = new FinancialRSI();
                        while (true) {
                        	
                        	System.out.println("                                      Enter the ticker symbol of");
                            System.out.print("                                      the stock to be monitored: ");
                			symbol = input.next().toUpperCase();
                			if (ob3.validateCall(symbol)) 
                			break;
                			
                			else
                				
                                System.out.println();
                                System.out.println("                                         ! ! ! Invalid Stock Symbol ! ! !");
                                System.out.println("                                        Monitored stocks must be currently");
                                System.out.println("                                      traded on the New York Stock Exchange.");
                			}

                        ob3.setSymbol(symbol);
                        int rsiLength = -1;
                        while (rsiLength < 0){
                            System.out.println();
                            System.out.println("                                      Enter the length of time in days");
                            System.out.println("                                      to be used in the calculation of");
                            System.out.print("                                      the relative strength index: ");
                            rsiLength = input.nextInt();
                            if (rsiLength < 0){
                                System.out.println();
                                System.out.println("                                      ! ! ! Invalid Number of Days ! ! !");
                                System.out.println("                                       Number must be greater than zero");
                            }
                        }
                        objects.add(ob3);
                        numberOfObjects ++;
                        break;

                        case 3:
                        FinancialSMA ob5 = new FinancialSMA();
                        while (true) {
                        	
                        	System.out.println("                                      Enter the ticker symbol of");
                            System.out.print("                                      the stock to be monitored: ");
                			symbol = input.next().toUpperCase();
                			if (ob5.validateCall(symbol)) 
                			break;
                			
                			else
                				
                                System.out.println();
                                System.out.println("                                         ! ! ! Invalid Stock Symbol ! ! !");
                                System.out.println("                                        Monitored stocks must be currently");
                                System.out.println("                                      traded on the New York Stock Exchange.");
                			}

                        ob5.setSymbol(symbol);
                        int smaShortTerm = -1;
                        while (smaShortTerm < 0){
                        System.out.println();
                        System.out.println("                                      Enter the length of time in days to");
                        System.out.println("                                      be used in the calculation of the");
                        System.out.print("                                      SHORT-TERM simple moving average: ");
                            smaShortTerm = input.nextInt();
                            if (smaShortTerm < 0){
                                System.out.println();
                                System.out.println("                                      ! ! ! Invalid Number of Days ! ! !");
                                System.out.println("                                       Number must be greater than zero");
                            }
                        }
                        int smaLongTerm = -1;
                        while (smaLongTerm < 0){
                        System.out.println();
                        System.out.println("                                      Enter the length of time in days to");
                        System.out.println("                                      be used in the calculation of the");
                        System.out.print("                                      LONG-TERM simple moving average: ");
                            smaLongTerm = input.nextInt();
                            if (smaLongTerm < 0){
                                System.out.println();
                                System.out.println("                                      ! ! ! Invalid Number of Days ! ! !");
                                System.out.println("                                       Number must be greater than zero");
                            }
                        }
                        ob5.setinitializeSt();
                        objects.add(ob5);
                        numberOfObjects ++;
                    }
                }

                else if (menuChoice == 2){
                    CryptoPrice ob2 = new CryptoPrice();
                    while (true) {
                    	
                        System.out.println("                                      Enter the cryptocurrency symbol");
                        System.out.println("                                      of the digital currency to be");
                        System.out.print("                                      monitored: ");
            			symbol = input.next().toUpperCase();
            			if (ob2.validateCall(symbol)) 
            			break;
            			
            			else
            				
                            System.out.println();
                            System.out.println("                                      ! ! ! Invalid Cryptocurrency Symbol ! ! !");
                            System.out.println("                                       Monitoring of the this digital currency");
                            System.out.println("                                             is not currently available.");
            			}

                    ob2.setMarket("Crypto");
                    ob2.setSymbol(symbol);
                    System.out.println();
                    System.out.printf("                                      The current price of " + symbol + " is %.2f%n",ob2.getPrice());
                    double percentIncrease = -1;
                    while (percentIncrease < 0){
                        System.out.println();
                        System.out.println("                                      Enter a percent INCREASE. A notification");
                        System.out.println("                                      will be displayed when the value of " + symbol);
                        System.out.print("                                      increases by this amount: ");
                        percentIncrease = input.nextDouble();
                        if (percentIncrease < 0){
                            System.out.println();
                            System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                            System.out.println("                                      Value must be greater than zero");
                        }
                    }
                    ob2.setPercentage(percentIncrease);
                    double percentDecrease = -1;
                    while (percentDecrease < 0 || percentDecrease > 100){
                        System.out.println();
                        System.out.println("                                      Enter a percent DECREASE. A notification");
                        System.out.println("                                      will be displayed when the value of " + symbol);
                        System.out.print("                                      decreases by this amount: ");
                        percentDecrease = input.nextDouble();
                        if (percentDecrease < 0){
                            System.out.println();
                            System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                            System.out.println("                                      Value must be greater than zero");
                        }
                        else if (percentDecrease > 100){
                            System.out.println();
                            System.out.println("                                        ! ! ! Invalid Percent ! ! !");
                            System.out.println("                                        Value must be less than 100");
                        }
                    }
                    percentDecrease *= -1;
                    ob2.setPercentage(percentDecrease);
                    ob2.setInitialValues();
                    objects.add(ob2);
                    numberOfObjects ++;
                }

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("                                      Would you like to configure monitoring");
                System.out.println("                                      of another financial item?");
                System.out.println();
                System.out.println("                                      Enter Y to continue setup");
                System.out.print("                                      or N to begin monitoring: ");
                continueLoop = input.next().charAt(0);
                System.out.println();
                System.out.println();
                System.out.println();
            }

            else if (menuChoice == 3) {
                System.out.println("                                      * * * * * * * * * * * * * * *");
                System.out.println("                                      *                           *");
                System.out.println("                                      *    About Armadillo 4000   *");
                System.out.println("                                      *                           *");
                System.out.println("                                      *        Coming Soon!       *");
                System.out.println("                                      *                           *");
                System.out.println("                                      * * * * * * * * * * * * * * *");
                System.out.println();
                System.out.println("                                         Press enter to continue");
                System.in.read();
                System.out.println();
                System.out.println();
                continueLoop = 'Y';
            }

            else if (menuChoice == 4) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("                                   ,:::://///,:::-.");
                System.out.println("                                  /:''/////// ``:::`;/|/     .--------------.");
                System.out.println("                                 /'   ||||||     :://'`\\     |   Goodbye!   |");
                System.out.println("                               .' ,   ||||||     `/(  e \\    /--------------'");
                System.out.println("                         -===~__-'\\__X_`````\\_____/~`-._ `.                 ");
                System.out.println("                                     ~~        ~~       `~-'");
                System.out.println();
                System.out.println();
                System.out.println();
                System.exit(0);
            }
        }

        System.out.println("                                      Would you like to view monitored");
        System.out.println("                                      financial data in realtime?");
        System.out.println();
        System.out.println("                                      Enter Y to view data in realtime");
        System.out.println("                                      or N to begin monitoring without");
        System.out.print("                                      realtime display: ");
        char consoleInputChoice = input.next().charAt(0);
        System.out.println();
        System.out.println();
        System.out.println();

	input.close();

        while(true){
            for(int i = 0; i < numberOfObjects; i++){
		if(Character.toUpperCase(consoleInputChoice) == 'Y'){
                    objects.get(i).setConsoleInput(1);
                }
		objects.get(i).compareValues();
            }
        }
    }
}