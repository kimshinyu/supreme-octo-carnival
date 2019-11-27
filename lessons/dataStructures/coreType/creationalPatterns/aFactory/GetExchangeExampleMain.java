package lessons.dataStructures.coreType.creationalPatterns.aFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Pros of factory pattern:
 * -if you kind of know how your objects are supposed to be, but want a different kind depending on input or something.
 * -
 */
public class GetExchangeExampleMain {

	public static void main(String[] args) throws IOException {
		GetExchangeFactory exchangeFactory = new GetExchangeFactory();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exchangeName = "";
		String pesosString = "";
		Double pesos;
		Exchange p;

		boolean cont = false;
		do {
			System.out.println("Enter the type of exchange to be used (Pesos to ..): ");
			exchangeName = br.readLine();

			if (ExchangeType.getByName(exchangeName).equals(ExchangeType.INVALID)) {
				System.out.println("The exchange name you have entered is invalid.");
			} else {
				System.out.print("Enter the number of Pesos to be calculated: ");
				pesosString = br.readLine();
				pesos = Double.parseDouble(pesosString);

				p = exchangeFactory.getExchange(exchangeName);
				System.out.print("For " + pesos + " pesos you can get ");
				p.setRate();
				p.calculateFromPesos(pesos);
				System.out.print(" " + exchangeName + "s.");
			}
			System.out.println();
			System.out.println("Do you want to continue?(Y/N): ");
			cont = br.readLine().equalsIgnoreCase("Y");
		} while (cont);
		System.out.println("Thanks for ending this process.");
	}
}
