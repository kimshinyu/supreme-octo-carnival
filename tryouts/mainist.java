package tryouts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mainist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainist m1 = new mainist();
		stringCompare s1 = new stringCompare();
		s1.setStr(m1.getString());
		stringCompare s2 = new stringCompare();
		s1.setStr(m1.getString());
		
		List<stringCompare> result = new ArrayList<stringCompare>();
		result.add(s1);
		result.add(s2);
		
		Collections.sort(result);
	}
	
	private String getString(){
		return null;
	}

}
