package lessons.dataStructures.coreType.creationalPatterns.bAbstractFactory.banks;

public class BankSantander implements BankInterface{

	private String name;
	
	public BankSantander(){
		name = "Banco Santander";
	}
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
