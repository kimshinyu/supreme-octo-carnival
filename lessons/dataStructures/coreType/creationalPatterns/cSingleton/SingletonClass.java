package lessons.dataStructures.coreType.creationalPatterns.cSingleton;

public class SingletonClass {

	private static SingletonClass instance;
	
//	this is not thread safe (multiple threads could instantiate the class and so,
//	multiple instances could be loaded
	
	private SingletonClass(){
	}
	
	public static SingletonClass getInstance(){
//	for it to be thread safe, it would be
//	public static synchronized SingletonClass getInstance(){
//	this one is very resource expensive
		
		if(instance == null){
			instance = new SingletonClass();
		}
		
		return instance;
	}
	
	public UserClass getUser(){
		UserClass user = new UserClass();
		
		user.setUsername("admin");
		user.setPassword("adminPass");
		
		return user;
	}
	
}

/*public class SingletonClass {

	private static SingletonClass instance = new SingletonClass();
//	this would be eager instantiation
//	only use when class is really light (it stays up from class load to app end)
//	this is thread safe
	
	private SingletonClass(){
	}
	
	public static SingletonClass getInstance(){
		return instance;
	}
	
	public UserClass getUser(){
		UserClass user = new UserClass();
		
		user.setUsername("admin");
		user.setPassword("adminPass");
		
		return user;
	}
	
}
*/