package lessons.dataStructures.coreType.creationalPatterns.fObjectPool;

public class ExportingProcess {

	private long processNo;
	
	public ExportingProcess(long processNo){
		this.processNo = processNo;
		//tasks
		System.out.println("Object with process no. " + processNo + " was created.");
	}
	
	public long getProcessNo(){
		return processNo;
	}
}
