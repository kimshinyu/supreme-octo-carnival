package lessons.dataStructures.coreType.structuralPatterns.cComposite;

import java.util.ArrayList;
import java.util.List;

public class DesktopComputer implements ProductInterface {

	private String brand;
	private double price;
	private List<ProductInterface> components = new ArrayList<>();

	public DesktopComputer(String brand){
		this.brand = brand;
	}
	@Override
	public String getType() {
		return "Desktop Computer";
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public double getPrice() {
		price = 0;
		for (ProductInterface c : components) {
			price += c.getPrice();
		}
		return price;
	}

	@Override
	public void print() {
		getPrice();
		System.out.println(getType() + "(brand: " + brand + ", price (total): " + price + ").");
		for (ProductInterface c : components) {
			System.out.print("\t");
			c.print();
		}
	}

	@Override
	public ProductInterface getChild(int i) {
		return components.get(i);
	}

	@Override
	public boolean peek(int i) {
		boolean result;
		if (components.isEmpty()) {
			System.out.println("No avaiable subcomponents found.");
			result = false;
		} else if (i < 0 || i > components.size() - 1) {
			System.out.println("Index out of bounds. Only " + (components.size() - 1) + " subcomponents found.");
			result = false;
		} else {
			System.out.println("Subcomponent of type " + components.get(i).getType() + " found at index " + i + ".");
			result = true;
		}

		return result;
	}

	@Override
	public void addSubProduct(ProductInterface prod) {
		components.add(prod);
		System.out.println("Product added: " + prod.getType() + ".");
	}

	@Override
	public void removeSubProduct(ProductInterface prod) {
		System.out.println(components.remove(prod) ? "Product removed: " + prod.getType()
				: "Product " + prod.getType() + " could not be removed.");
	}

}
