package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks;

public class BankBBVA implements BankInterface{

	private String name;
	
	public BankBBVA(){
		name = "Banco BBVA";
	}
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}

