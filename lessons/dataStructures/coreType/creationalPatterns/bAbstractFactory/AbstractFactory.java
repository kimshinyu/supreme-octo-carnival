package lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory;

import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.banks.BankInterface;
import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.loans.LoanAbstractClass;

public abstract class AbstractFactory {
	public abstract BankInterface getBank(String bank);

	public abstract LoanAbstractClass getLoan(String loan);
}
