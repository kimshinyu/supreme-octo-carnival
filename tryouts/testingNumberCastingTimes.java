package tryouts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testingNumberCastingTimes {


	static File txt = new File("C://Users//aronkim//Desktop//PrivateWorkspace//supreme-octo-carnival//tryouts//Untitled 1");
	static Scanner sc;
	
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(txt);
		
		long start = System.currentTimeMillis();

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			aron();
		}

		long end = System.currentTimeMillis();
		System.out.println("Aron's " + "method: " + (end - start));

		System.out.println();

		sc = new Scanner(txt);
		start = System.currentTimeMillis();

		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			aviAndLahouari();
		}

		end = System.currentTimeMillis();
		System.out.println("avi89 and Lahouari's " + "method: " + (end - start));
		
		sc.close();
	}
	
	private static void aron(){
		try
        {
            long x=sc.nextLong();
            boolean stillLooking = true;

            if(stillLooking && (x < Long.MIN_VALUE)){
                //System.out.println(x + " can't be fitted anywhere.");
                stillLooking = false;
            }
            if(stillLooking && (x < Integer.MIN_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x < Short.MIN_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* int");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x < Byte.MIN_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* short");
                //System.out.println("* int");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x <= Byte.MAX_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* byte");
                //System.out.println("* short");
                //System.out.println("* int");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x <= Short.MAX_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* short");
                //System.out.println("* int");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x <= Integer.MAX_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* int");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking && (x <= Long.MAX_VALUE)){
                //System.out.println(x + " can be fitted in:");
                //System.out.println("* long");
                stillLooking = false;
            }
            if(stillLooking){
                //System.out.println(x + " can't be fitted anywhere.");
            }
        }
        catch(Exception e)
        {
            System.out.println(sc.next()+" can't be fitted anywhere.");
        }
	}

	private static void aviAndLahouari(){
		try {
			long x = sc.nextLong();
			//System.out.println(x + " can be fitted in:");
			if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
				//System.out.println("* byte");
			}
			if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
				//System.out.println("* short");
			}
			if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
				//System.out.println("* int");
			}
			if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
				//System.out.println("* long");
			}
		} catch (Exception e) {
			System.out.println(sc.next() + " can't be fitted anywhere.");
		}
	}

	

}
