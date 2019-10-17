package lessons.dataStructures.coreType.creationalPatterns.cSingleton;

public class UserClass {

	private String username;
	private String password;

	public UserClass(){
		username = "admin";
		password = "adminpass";
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "Username: " + username + "; Password: " + password + ".";
	}
}
