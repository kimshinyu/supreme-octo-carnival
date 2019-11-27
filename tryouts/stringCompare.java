package tryouts;

public class stringCompare  implements Comparable<stringCompare>{
	
	private  String str;

	public  String getStr() {
		return str;
	}

	public  void setStr(String str) {
		this.str = str;
	}

	@Override
	public int compareTo(stringCompare o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    int comparison = this.getStr().compareToIgnoreCase(o.getStr());
	    if(comparison != EQUAL) return comparison;
	    
	    return 0;
	}
	
}
