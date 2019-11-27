package lessons.dataStructures.coreType.creationalPatterns.dPrototype;

import java.util.Date;

public class Employee implements PrototypeInterface{

	private String name;
	private int age;
	private double salary;
	private String position;
	private Date startingDate;
	
	private Employee(){}
	
	public Employee(String name, int age, double salary, String position, Date startingDate){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.position = position;
		this.startingDate = startingDate;
	}
	
	public String toString(){
		return "The employee's data: (Name)" + name + "; (Age)" + age + 
				"; (Salary)" + salary + "; (Position)" + position +
				"; (Starting Date)" + startingDate + ".";
	}
	
	@Override
	public PrototypeInterface getClone() {
		return new Employee(name,age,salary,position,startingDate);
	}

}
