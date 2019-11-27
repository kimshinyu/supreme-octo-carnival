package lessons.dataStructures.coreType.structuralPatterns.eFacade;

public class FacadeExampleMain {

	public static void main(String[] args) {
		//la idea es descomplejizar el sistema para el cliente
		//brinda una interface a las variadas interfaces de los subsystemas
		
		Compilator comp = new Compilator();
		comp.javaCompile();
		comp.cppCompile();
		comp.pythonCompile();
		System.out.println("Compilator finished runs.");
	}

}
