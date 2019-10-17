package lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory;

import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.banks.BankFactory;
import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.loans.LoanFactory;

public class FactoryCreator {
	 public static AbstractFactory getFactory(String choice){  
	      if(choice.equalsIgnoreCase("Bank")){  
	         return new BankFactory();  
	      } else if(choice.equalsIgnoreCase("Loan")){  
	         return new LoanFactory();  
	      }  
	      return null;  
	   }  
}
