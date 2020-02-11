package lessons.Otros.FuncionesLambda;

public class App {

	public static void main(String[] args) {
		
		System.out.println("This is me, tryout this Lambda Function thingy from Java 8.");
		Runnable r = new Runnable();
		r.run(new Executable() {
			public void execute() {
				System.out.println("Executable is being executed.");
			}
		});
		
		System.out.println("-------------------------------");
		System.out.println("Now the same, but lambda-y.");
		
		r.run(() -> {
			System.out.println("Executable is being executed in a lambda-y way.");
		});

	}
}
