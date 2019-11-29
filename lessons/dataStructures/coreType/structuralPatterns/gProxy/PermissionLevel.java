package lessons.dataStructures.coreType.structuralPatterns.gProxy;

public enum PermissionLevel {
	STRANGER(0), GUEST(1), USER(2), ADMIN(3);
	
	private int level;
	
	private PermissionLevel(int level) {
	}
	
	public int getLevel(){
		return level;
	}
}
