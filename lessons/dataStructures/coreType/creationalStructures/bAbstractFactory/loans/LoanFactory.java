package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.loans;

import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.AbstractFactory;
import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks.BankInterface;

public class LoanFactory extends AbstractFactory {
	public BankInterface getBank(String bank) {
		return null;
	}

	public LoanAbstractClass getLoan(String loan) {
		if (loan == null) {
			return null;
		}
		if (loan.equalsIgnoreCase("Personal")) {
			return new LoanPersonal();
		} else if (loan.equalsIgnoreCase("Business")) {
			return new LoanBussiness();
		} else if (loan.equalsIgnoreCase("Preferential")) {
			return new LoanPreferential();
		}
		return null;
	}
}
