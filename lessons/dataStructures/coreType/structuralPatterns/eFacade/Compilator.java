package lessons.dataStructures.coreType.structuralPatterns.eFacade;

public class Compilator {
	private JavaCompiler javaCompiler = new JavaCompiler();
	private CppCompiler cppCompiler = new CppCompiler();
	private PythonCompiler pythonCompiler = new PythonCompiler();
	
	public void javaCompile(){
		javaCompiler.compile();
	}
	
	public void cppCompile(){
		cppCompiler.compile();
	}
	
	public void pythonCompile(){
		pythonCompiler.compile();
	}
}
