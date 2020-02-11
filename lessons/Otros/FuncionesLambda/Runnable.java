package lessons.Otros.FuncionesLambda;

class Runnable {
	public Runnable(){}
	
	public void run(Executable e){
		System.out.println("A runnable is running.");
		e.execute();
	}
}
