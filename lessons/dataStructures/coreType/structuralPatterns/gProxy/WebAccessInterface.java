package lessons.dataStructures.coreType.structuralPatterns.gProxy;

import java.util.List;

public interface WebAccessInterface {

	public List<String> getAllowed(int permission);

	public void addToAllowed(String url, int permission);

	public void removeFromAllowed(String url, int permission);

}
