package lessons.dataStructures.coreType.creationalStructures.aFactory;

public enum ExchangeType {
	INVALID("INVALID"),DOLLAR("DOLLAR"),EURO("EURO"),WON("WON");
	
	private String name;
	
	private ExchangeType(String s){}
	
	public String getName(){
		return name;
	}
	
	public static ExchangeType getByName(String s){
		if(s.equals(DOLLAR.getName())){
			return DOLLAR;
		}else if(s.equals(EURO.getName())){
			return EURO;
		}else if(s.equals(WON.getName())){
			return WON;
		}
		return INVALID;
	}
}
