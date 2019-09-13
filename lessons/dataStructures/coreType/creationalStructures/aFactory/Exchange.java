package lessons.dataStructures.coreType.creationalStructures.aFactory;

abstract class Exchange {
	double rate;
	
	abstract void setRate();
	
	public void calculateFromPesos(double pesos){  
        System.out.print(pesos*rate);
    }
}
