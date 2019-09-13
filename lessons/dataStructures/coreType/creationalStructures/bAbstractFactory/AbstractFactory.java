package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory;

import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks.BankInterface;
import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.loans.LoanAbstractClass;

public abstract class AbstractFactory {
	public abstract BankInterface getBank(String bank);

	public abstract LoanAbstractClass getLoan(String loan);
}
