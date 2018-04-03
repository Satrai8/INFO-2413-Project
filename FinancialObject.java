import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This is the superclass being used to base all our subclasses off of


public abstract class FinancialObject {
	
	String apiKey = "U7CEKTSD7MP0A660";
    String symbol;
    String market;
    Boolean consoleView = false;


    public void setSymbol(String mySymbol) {

        symbol = mySymbol;
    }

    public void setMarket(String myMarket) {

        market = myMarket;
    }

    // abstract classes that are defined with different method bodies in the subclasses

    public abstract void compareValues();	//used to check the rule for each different subclass
    public abstract void setInitialValues();	// sets the starting values (price etc.) for comparison purposes


    // Check if user wants to display output on screen
    public void setConsoleInput(int x) {

        if (x == 1)
            consoleView = true;

        else consoleView = false;
    }


    public String getDate() {	// current timestamp

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public abstract boolean validateCallSymbol(String inputSymbol) throws IOException;

}