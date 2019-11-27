package lessons.dataStructures.coreType.structuralPatterns.cComposite;

public interface ProductInterface {
	public String getType();

	public String getBrand();

	public double getPrice();

	public void print();

	public ProductInterface getChild(int i);

	public boolean peek(int i);

	public void addSubProduct(ProductInterface prod);

	public void removeSubProduct(ProductInterface prod);
}
