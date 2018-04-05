import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FinancialSMA extends FinancialObject {

    int shortTermPeriod;
    int longTermPeriod;
    double initialShortTerm;
    double initialLongTerm;
    boolean shortTermBeginHigher = false;
    int timePeriod = 5;



    public FinancialSMA() {

    }

    @Override
    public void setInitialValues() {


        String myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=" + shortTermPeriod + "&series_type=close&apikey=" + apiKey;




        try {

            URL url = new URL(myString);

            URLConnection hc = url.openConnection();

            InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;

            BufferedReader buff = new BufferedReader(myStream);

            String line = buff.readLine();

            String stSMA = "not initiated";



            while (line != null && stSMA.equals("not initiated")) {


                if (line.contains("\"SMA\"")) {

                    int index = line.indexOf("\"SMA\"");
                    int decimal = line.indexOf(".", index);
                    int start = decimal;

                    while (line.charAt(start) != '\"')
                        start--;
                    stSMA = line.substring(start + 1, decimal + 5);
                    initialShortTerm = Double.parseDouble(stSMA);



                }


                line = buff.readLine();

            }
        } catch (MalformedURLException e) {
            System.err.println("Connection error. Please restart the program.");
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {

            Thread.sleep(2 * 1000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }


        myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=" + longTermPeriod + "&series_type=close&apikey=" + apiKey;




        try {

            URL url = new URL(myString);

            URLConnection hc = url.openConnection();

            InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;

            BufferedReader buff = new BufferedReader(myStream);

            String line = buff.readLine();

            String ltSMA = "not initiated";



            while (line != null && ltSMA.equals("not initiated")) {


                if (line.contains("\"SMA\"")) {

                    int index = line.indexOf("\"SMA\"");
                    int decimal = line.indexOf(".", index);
                    int start = decimal;

                    while (line.charAt(start) != '\"')
                        start--;
                    ltSMA = line.substring(start + 1, decimal + 5);
                    initialLongTerm = Double.parseDouble(ltSMA);

                }


                line = buff.readLine();

            }
        } catch (MalformedURLException e) {
            System.err.println("Connection error. Please restart the program.");
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {

            Thread.sleep(2 * 1000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }


        if (initialShortTerm> initialLongTerm) {
            shortTermBeginHigher = true;
        }




    }


    @Override
    public void compareValues() {


        double currentShortTerm = 0.0;

        String myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=" + shortTermPeriod + "&series_type=close&apikey=" + apiKey;




        try {

            URL url = new URL(myString);

            URLConnection hc = url.openConnection();

            InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;

            BufferedReader buff = new BufferedReader(myStream);

            String line = buff.readLine();

            String stSMA = "not initiated";



            while (line != null && stSMA.equals("not initiated")) {


                if (line.contains("\"SMA\"")) {

                    int index = line.indexOf("\"SMA\"");
                    int decimal = line.indexOf(".", index);
                    int start = decimal;

                    while (line.charAt(start) != '\"')
                        start--;
                    stSMA = line.substring(start + 1, decimal + 5);
                    currentShortTerm = Double.parseDouble(stSMA);


                }


                line = buff.readLine();

            }
        } catch (MalformedURLException e) {
            System.err.println("Connection error. Please restart the program.");
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {

            Thread.sleep(2 * 1000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }


        double currentLongTerm = 0.0;



        myString = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=" + longTermPeriod + "&series_type=close&apikey=" + apiKey;




        try {

            URL url = new URL(myString);

            URLConnection hc = url.openConnection();

            InputStreamReader myStream = new InputStreamReader(hc.getInputStream());;

            BufferedReader buff = new BufferedReader(myStream);

            String line = buff.readLine();

            String ltSMA = "not initiated";



            while (line != null && ltSMA.equals("not initiated")) {


                if (line.contains("\"SMA\"")) {

                    int index = line.indexOf("\"SMA\"");
                    int decimal = line.indexOf(".", index);
                    int start = decimal;

                    while (line.charAt(start) != '\"')
                        start--;
                    ltSMA = line.substring(start + 1, decimal + 5);
                    currentLongTerm = Double.parseDouble(ltSMA);

                    if (consoleView) {

                    	for(int i=0; i<30; i++)
                        	System.out.println();
                    	
                        System.out.println("                                               ,.-----__");
                        System.out.println("                                            ,:::://///,:::-.");
                        System.out.println("                                           /:''/////// ``:::`;/|/");
                        System.out.println("                                          /'   ||||||     :://'`\\");
                        System.out.println("                                        .' ,   ||||||     `/(  e \\");
                        System.out.println("                                  -===~__-'\\__X_`````\\_____/~`-._ `.");
                        System.out.println("                                              ~~        ~~       `~-'");
                        System.out.println();
                        System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                        System.out.println();
                        System.out.println("                                          " + getDate());
                        System.out.println();
                        System.out.println("                            The current short-term SMA for " + symbol + " is " + currentShortTerm);
                        System.out.println("                            The current long-term SMA for " + symbol + " is " + currentLongTerm);
                        System.out.println();
                        System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");

                        for(int i=0; i<26; i++)
                        	System.out.println();
                    }
                }

                line = buff.readLine();

            }
        } catch (MalformedURLException e) {
            System.err.println("Connection error. Please restart the program.");
        } catch (IOException e) {

            e.printStackTrace();
        }

        try {

            Thread.sleep(2 * 1000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }

        
        if (shortTermBeginHigher) {

            if (currentShortTerm < currentLongTerm) {

            	for(int i=0; i<30; i++)
                	System.out.println();
            	
                System.out.println("                                      ,.-----__");
                System.out.println("                                   ,:::://///,:::-.");
                System.out.println("                                  /:''/////// ``:::`;/|/     .---------------.");
                System.out.println("                                 /'   ||||||     :://'`\\     |   Sell Now!   |");
                System.out.println("                               .' ,   ||||||     `/(  e \\    /---------------'");
                System.out.println("                         -===~__-'\\__X_`````\\_____/~`-._ `.");
                System.out.println("                                     ~~        ~~       `~-'");
                System.out.println();
                System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                System.out.println();
                System.out.println("                                          " + getDate());
                System.out.println();
                System.out.println("                                The short-term SMA (" + currentShortTerm + ") for " + symbol);
                System.out.println("                            has dropped below the long-term SMA (" + currentLongTerm + ")");
                System.out.println();
                System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");

                for(int i=0; i<26; i++)
                	System.out.println();        
            }


        } else {
            if (currentShortTerm > currentLongTerm) {

            	for(int i=0; i<30; i++)
                	System.out.println();
            	
                System.out.println("                                      ,.-----__");
                System.out.println("                                   ,:::://///,:::-.");
                System.out.println("                                  /:''/////// ``:::`;/|/     .--------------.");
                System.out.println("                                 /'   ||||||     :://'`\\     |   Buy Now!   |");
                System.out.println("                               .' ,   ||||||     `/(  e \\    /--------------'");
                System.out.println("                         -===~__-'\\__X_`````\\_____/~`-._ `.");
                System.out.println("                                     ~~        ~~       `~-'");
                System.out.println();
                System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                System.out.println();
                System.out.println("                                          " + getDate());
                System.out.println();
                System.out.println("                                The short-term SMA (" + currentShortTerm + ") for " + symbol);
                System.out.println("                             has risen above the long-term SMA (" + currentLongTerm + ")");
                System.out.println();
                System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");

                for(int i=0; i<26; i++)
                	System.out.println();
            }
        }
    }

    public void setSMAShortTerm(int inputShortTerm) {

        shortTermPeriod = inputShortTerm;
    }

    public void setSMALongTerm(int inputLongTerm) {

        longTermPeriod = inputLongTerm;


    }

    @Override
    public boolean validateCallSymbol(String inputSymbol) throws IOException {

        String str = "https://www.alphavantage.co/query?function=SMA&symbol=" + inputSymbol + "&interval=1min&time_period=5&series_type=close&apikey=" + apiKey;
        int lineIndex = 0;
        boolean valid = true;


        URL url = new URL(str);

        URLConnection hc = url.openConnection();

        InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;

        BufferedReader buff = new BufferedReader(mystream);

        String line = buff.readLine();

        while (line != null && lineIndex < 2) {

            if (line.contains("Error"))
                valid = false;

            line = buff.readLine();
            lineIndex++;
        }
        return valid;

    }


    public boolean validateCallTimePeriod(int inputTime) throws IOException {

        String str = "https://www.alphavantage.co/query?function=SMA&symbol=" + symbol + "&interval=1min&time_period=" + inputTime + "&series_type=close&apikey=" + apiKey;
        int lineIndex = 0;
        boolean valid = true;


        URL url = new URL(str);

        URLConnection hc = url.openConnection();

        InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;

        BufferedReader buff = new BufferedReader(mystream);

        String line = buff.readLine();

        while (line != null && lineIndex < 30) {


            if (line.contains("{}") || line.contains("Error"))
                valid = false;

            line = buff.readLine();
            lineIndex++;
        }
        return valid;

    }

    public void setTimePeriod(int rsiLength) {

        timePeriod = rsiLength;

    }

}