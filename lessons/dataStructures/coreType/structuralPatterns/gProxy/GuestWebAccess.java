package lessons.dataStructures.coreType.structuralPatterns.gProxy;

import java.util.ArrayList;
import java.util.List;

public class GuestWebAccess implements WebAccessInterface {

	private final PermissionLevel minPermission = PermissionLevel.GUEST;
	private final List<String> allowed = new ArrayList<String>() {
		private static final long serialVersionUID = 1L; // no se por que es necesario este
		{
			add("www.google.com");
			add("www.twitter.com");
		}
	};

	@Override
	public List<String> getAllowed(int permission) {
		if (permission >= minPermission.getLevel()) {
			System.out.println("Reading access allowed.");
			return allowed;
		}
		System.out.println("Reading access denied.");
		return new ArrayList<>();
	}

	@Override
	public void addToAllowed(String url, int permission) {
		if (permission >= minPermission.getLevel()) {
			System.out.println("Writing access allowed.");
			allowed.add(url);
		} else {
			System.out.println("Writing access denied.");
		}
	}

	@Override
	public void removeFromAllowed(String url, int permission) {
		if (permission >= minPermission.getLevel()) {
			System.out.println("Removal access allowed.");
			allowed.remove(url);
		} else {
			System.out.println("Removal access denied.");
		}
	}

}
