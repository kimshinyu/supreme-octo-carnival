package lessons.dataStructures.coreType.creationalPatterns.eBuilder.Example1;

public class CDBuilder {
	public CDType buildSonyCD(){
		CDType cds = new CDType();
		cds.addItem(new CompanySony());
		return cds;
	}
	public CDType buildSamsungCD(){
		CDType cds = new CDType();
		cds.addItem(new CompanySamsung());
		return cds;
	}
}
