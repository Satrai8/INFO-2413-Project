
// This is the superclass being used to base all our subclasses off of


public abstract class FinancialObject {
	
	String symbol;
	String market;
	

	public void setSymbol(String mySymbol){
		
		symbol = mySymbol;
	}
	
	public void setMarket(String myMarket){
		
		market = myMarket;
		}
		
	// abstract classes that are defined with different method bodies in the subclasses
	
	public abstract void compareValues();
	
	public abstract void setInitialValues();
		
}


