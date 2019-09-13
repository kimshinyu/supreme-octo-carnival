package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks;

import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.AbstractFactory;
import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.loans.LoanAbstractClass;

public class BankFactory extends AbstractFactory{
	   public BankInterface getBank(String bank){  
		      if(bank == null){  
		         return null;  
		      }  
		      if(bank.equalsIgnoreCase("Santander")){  
		         return new BankSantander();  
		      } else if(bank.equalsIgnoreCase("HSBC")){  
		         return new BankHSBC();  
		      } else if(bank.equalsIgnoreCase("BBVA")){  
		         return new BankBBVA();  
		      }  
		      return null;  
		   }  
		  public LoanAbstractClass getLoan(String loan) {  
		      return null;  
		   }  
}
