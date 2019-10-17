package lessons.dataStructures.coreType.creationalPatterns.cSingleton;

public enum SingletonEnum {
	INSTANCE;
	
	private static String user = "admin";
	
	public String getUser(){
		return SingletonEnum.user;
	}
	
	public void setUser(String user){
		SingletonEnum.user = user;
	}
	
}
