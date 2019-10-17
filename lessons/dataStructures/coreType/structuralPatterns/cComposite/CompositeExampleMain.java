package lessons.dataStructures.coreType.structuralPatterns.cComposite;

public class CompositeExampleMain {

	//when you want a tree-like structure; a hierarchical structure where you do the same stuff to all parts
	public static void main(String[] args) {
		ProductInterface cooler = new Cooler("AquaPower", 30.00);
		ProductInterface cpu = new CPU("Intel", 60.00);
		ProductInterface gpu = new GPU("NVidia", 70.00);
		ProductInterface hdd = new HDD("Samsung", 60.00);
		ProductInterface ram1 = new RAM("XVerizon", 35.00);
		ProductInterface ram2 = new RAM("XVerizon", 35.00);
		ProductInterface desktop = new DesktopComputer("DELL");

		desktop.addSubProduct(cooler);
		desktop.addSubProduct(cpu);
		desktop.addSubProduct(gpu);
		desktop.addSubProduct(hdd);
		desktop.addSubProduct(ram1);
		desktop.addSubProduct(ram2);
		desktop.print();
	}

}
