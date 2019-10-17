package lessons.dataStructures.coreType.creationalPatterns.aFactory;

class GetExchangeFactory {
	       public Exchange getExchange(String exchangeType){  
	            if(exchangeType == null | exchangeType.isEmpty()){  
	             return null;  
	            }  
	          if(exchangeType.equalsIgnoreCase("DOLLAR")) {  
	                 return new DollarExchange();  
	               }   
	           else if(exchangeType.equalsIgnoreCase("EURO")){  
	                return new EuroExchange();  
	            }   
	          else if(exchangeType.equalsIgnoreCase("WON")) {  
	                return new WonExchange();  
	          }  
	      return null;  
	   }  
	}