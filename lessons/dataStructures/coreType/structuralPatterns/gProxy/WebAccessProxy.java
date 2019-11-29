package lessons.dataStructures.coreType.structuralPatterns.gProxy;

import java.util.List;

public class WebAccessProxy {
	private int permission;
	private WebAccessInterface access;

	public WebAccessProxy(int permission) {
		this.permission = permission;
		switch (permission) {
		case 1:
			access = new GuestWebAccess();
			break;
		case 2:
			access = new UserWebAccess();
			break;
		case 3:
			access = new AdminWebAccess();
			break;
		default:
			access = new StrangerWebAccess();
		}
	}

	public List<String> getAllowed() {
		return access.getAllowed(this.permission);
	}

	public void addToAllowed(String url) {
		access.addToAllowed(url, this.permission);
	}

	public void removeFromAllowed(String url, int permission) {
		access.removeFromAllowed(url, this.permission);
	}

}
