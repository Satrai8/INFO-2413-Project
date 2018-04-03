import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FinancialRSI extends FinancialObject {

    int timePeriod = 10;

    public FinancialRSI() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void compareValues() {

        double RSI = 0.0;

        String myString = "https://www.alphavantage.co/query?function=RSI&symbol=" + symbol + "&interval=15min&time_period=" + timePeriod + "&series_type=close&apikey=" + apiKey;

        try {

            URL url = new URL(myString);

            URLConnection hc = url.openConnection();

            InputStreamReader mystream = new InputStreamReader(hc.getInputStream());;

            BufferedReader buff = new BufferedReader(mystream);

            String line = buff.readLine();

            String strRSI = "no price available";

            line = buff.readLine();



            while (line != null && RSI == 0) {

                if (line.contains("\"RSI\"")) {

                    int index = line.indexOf("\"RSI\"");
                    int decimal = line.indexOf(".", index);
                    int start = decimal;

                    while (line.charAt(start) != '\"')
                        start--;
                    strRSI = line.substring(start + 1, decimal + 5);
                    RSI = Double.parseDouble(strRSI);

                    if (consoleView) {
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
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
                        System.out.println("                                 The current RSI for " + symbol + " is " + RSI + "%");
                        System.out.println();
                        System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }

                    if (RSI > 70) {
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
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
                        System.out.println("                                          " + symbol + " is overbought.");
                        System.out.println("                                     Its RSI just reached " + RSI + "%");
                        System.out.println();
                        System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    } else if (RSI < 30) {
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
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
                        System.out.println("                                           " + symbol + " is oversold.");
                        System.out.println("                                     Its RSI just reached " + RSI + "%");
                        System.out.println();
                        System.out.println("                         $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
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
    }

    @Override
    public void setInitialValues() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean validateCallSymbol(String inputSymbol) throws IOException {

        String str = "https://www.alphavantage.co/query?function=RSI&symbol=" + inputSymbol + "&interval=15min&time_period=10&series_type=close&apikey=" + apiKey;
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

        String str = "https://www.alphavantage.co/query?function=RSI&symbol=" + symbol + "&interval=15min&time_period=" + inputTime + "&series_type=close&apikey=" + apiKey;
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