package lessons.dataStructures.coreType.creationalStructures.bAbstractFactory.banks;

public class BankHSBC  implements BankInterface{

	private String name;
	
	public BankHSBC(){
		name = "Banco HSBC";
	}
	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
