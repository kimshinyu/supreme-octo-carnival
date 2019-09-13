package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks.BankInterface;
import lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.loans.LoanAbstractClass;

public class AbstractFactoryExampleMain {
	public static void main(String[] args) throws IOException {

		BufferedReader br;
		String bankName;
		String loanName;
		BankInterface b;
		AbstractFactory bankFactory;
		double rate;
		double loanAmount;
		int years;
		AbstractFactory loanFactory;
		LoanAbstractClass l;

		boolean cont = false;
		do {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter the name of Bank from where you want to take loan amount: ");
			bankName = br.readLine();

			System.out.print("\n");

			System.out.print("Enter the type of loan e.g. personal loan or business loan or preferential loan : ");
			loanName = br.readLine();

			bankFactory = FactoryCreator.getFactory("Bank");
			b = bankFactory.getBank(bankName);

			System.out.print("\n");
			System.out.print("Enter the interest rate for " + b.getBankName() + ": ");
			rate = Double.parseDouble(br.readLine());

			System.out.print("\n");
			System.out.print("Enter the loan amount you want to take: ");
			loanAmount = Double.parseDouble(br.readLine());

			System.out.print("\n");
			System.out.print("Enter the number of years to pay your entire loan amount: ");
			years = Integer.parseInt(br.readLine());

			System.out.print("\n");
			System.out.println("You are taking the loan from " + b.getBankName() + ".");

			loanFactory = FactoryCreator.getFactory("Loan");
			l = loanFactory.getLoan(loanName);
			l.setInterestRate(rate);
			l.calculateLoanPayment(loanAmount, years);

			System.out.println();
			System.out.println("Do you want to continue?(Y/N): ");
			cont = br.readLine().equalsIgnoreCase("Y");
		} while (cont);
		System.out.println("Thanks for ending this process.");
	}
}
