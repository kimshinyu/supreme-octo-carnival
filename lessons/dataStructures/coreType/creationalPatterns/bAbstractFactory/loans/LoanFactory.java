package lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.loans;

import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.AbstractFactory;
import lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.banks.BankInterface;

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
