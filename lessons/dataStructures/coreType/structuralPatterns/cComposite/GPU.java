package lessons.dataStructures.coreType.structuralPatterns.cComposite;

public class GPU implements ProductInterface {

	private String brand;
	private double price;

	public GPU(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}

	@Override
	public String getType() {
		return "GPU";
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void print() {
		System.out.println(getType() + "(brand: " + brand + ", price: " + price + ").");
	}

	@Override
	public ProductInterface getChild(int i) {
		return null;
	}

	@Override
	public boolean peek(int i) {
		return false;
	}

	@Override
	public void addSubProduct(ProductInterface prod) {
	}

	@Override
	public void removeSubProduct(ProductInterface prod) {
	}

}
