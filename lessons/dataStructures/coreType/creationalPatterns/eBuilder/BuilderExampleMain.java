package lessons.dataStructures.coreType.creationalPatterns.eBuilder;

import java.util.Scanner;

import lessons.dataStructures.coreType.creationalPatterns.eBuilder.Example1.CDBuilder;
import lessons.dataStructures.coreType.creationalPatterns.eBuilder.Example1.CDType;
import lessons.dataStructures.coreType.creationalPatterns.eBuilder.Example1.CompanySamsung;
import lessons.dataStructures.coreType.creationalPatterns.eBuilder.Example1.CompanySony;

public class BuilderExampleMain {

	//The builder pattern is about separating the class to be used itself from the construction process, relegating
	//it to another 'builder' class
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the number of Sony CDs you want to create: ");
		int sonyQuant = scanner.nextInt();
		System.out.println();
		System.out.print("Please enter the number of Samsung CDs you want to create: ");
		int samsungQuant = scanner.nextInt();
		
		CDBuilder cdBuilder = new CDBuilder();
		CDType cdType1 = cdBuilder.buildSonyCD();
		for(int i = 1; i < sonyQuant; i++){
			cdType1.addItem(new CompanySony());
		}
		cdType1.showItems();
		
		CDType cdType2 = cdBuilder.buildSamsungCD();
		for(int i = 1; i < samsungQuant; i++){
			cdType2.addItem(new CompanySamsung());
		}
		cdType2.showItems();
	}

}
