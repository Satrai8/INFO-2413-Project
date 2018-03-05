
public abstract class FinancialObject {
	
	String symbol;
	String market;
	
	
	

	
	
	
	

	
	
	
	public void setSymbol(String mySymbol){
		
		symbol = mySymbol;
	}
	
	public void setMarket(String myMarket){
		
		market = myMarket;
		
		
	}
	
	public abstract void compareValues();
	
	public abstract void setInitialValues();

	
		
	}


