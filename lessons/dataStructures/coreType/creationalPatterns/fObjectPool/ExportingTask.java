package lessons.dataStructures.coreType.creationalPatterns.fObjectPool;

public class ExportingTask implements Runnable{

	private ObjectPool<ExportingProcess> pool;
	private int threadNo;
	
	public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNo){
		this.pool = pool;
		this.threadNo = threadNo;
	}
	
	@Override
	public void run() {
		ExportingProcess exportingProcess = pool.borrowObject();
        System.out.println("Thread " + threadNo + ": Object with process no. " + exportingProcess.getProcessNo() + " was borrowed");
        //Stuff You Want To Do With The Exporting Process
        pool.returnObject(exportingProcess);
        System.out.println("Thread " + threadNo +": Object with process no. " + exportingProcess.getProcessNo() + " was returned");  
	}

}
