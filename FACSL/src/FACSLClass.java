 import java.util.Arrays;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
//Made by REMY YOUNG 
// CS3A
// TEST DATA
// INPUT
// 1.  3, a, b
//Should return:
// 1.     0
// 2.     .00
// 3.     xx-
// 4.     0
// 5.     67%
public class FACSLClass {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String[] data = input.nextLine().split(", ");
		String[] data2 = Arrays.copyOf(data,data.length);
		data = Arrays.copyOf(data, Integer.parseInt(data[0]));
		char[] dataChar = new char [data2.length-1]; // actual letters
		int[] dataInt = new int[data2.length-1]; //number assigned to the letters
		int[] charLength = new int[data2.length-1]; // count the number of collisions
		//create all of the different arrays for use
		for(int forLoop = 1; forLoop<data2.length; forLoop ++)
		{
			if(data2[forLoop] != null)
			{
				dataChar[forLoop - 1] = data2[forLoop].charAt(0);
			}
		}
		for(int forLoop = 0; forLoop<data2.length-1; forLoop ++)
		{
			if(dataChar[forLoop] == 0)
			{
			}
			else
			{
				char charComparer = dataChar[forLoop];
				int intComparer = charComparer -'a'; //constantly subtract a to get the proper value
				intComparer = intComparer % Integer.parseInt(data[0]);
				// test code System.out.println(intComparer);
				dataInt[forLoop] = intComparer;
			}
		}
		int collisionCount = 0;
		// test code System.out.println("data length" +(data2.length-1));
		//count the number of collisions
		for(int forLoop = 0; forLoop<Integer.parseInt(data[0]) && forLoop< data2.length -2; forLoop ++)
		{
			for(int cycle = 0;cycle<data2.length-1; cycle++)
			{
				if(forLoop == dataInt[cycle]&& cycle!= forLoop)
				{
					//charLength[dataInt[forLoop]] = charLength[dataInt[forLoop]]+1; // collision occures
					charLength[forLoop] = charLength[forLoop] +1;

					collisionCount ++;
				}
				//System.out.println(charLength[forLoop]);
			}
		}
		//testcode
		//System.out.println("charLength SIZE 0" + charLength[0]);
		//System.out.println("charLength SIZE 1" + charLength[1]);
		//System.out.println("charLength SIZE 2" + charLength[2]);
		System.out.println("1.     " + collisionCount);
		//collision rate
		double collisionRate = ((collisionCount)/(double)(data2.length-1));
		DecimalFormat f = new DecimalFormat("##.00");
		System.out.println("2.     " + f.format(collisionRate));
		
		//Table Mask
		int numberOfXs = 0;
		char[] mask = new char[Integer.parseInt(data[0])];
		Arrays.fill(mask, '-');
		for(int i : dataInt) {
			mask[i]= 'x';
		
		}
		String output = "";
		for(char c : mask) {
			output+=c;
		}
		System.out.println("3.     "+ output);
		
		//count how many x's there are
		for(int c= 0; c<mask.length; c++)
		{
			if(mask[c] == 'x')
			{
				numberOfXs ++;
			}
		}
		
		//Another way of doing table mask
		/*
		System.out.print("3.     ");
		int numberOfXs = 0;
		for (int i = 0; i < Integer.parseInt(data[0]); i++) {
			char o = '-';
			for(int hash : dataInt) {
				if(hash==i){
					o = 'x';
				}
			}
			
			System.out.print(o);
		}
		System.out.println("");
		
		*/
		

		//max chain depth
		int maxDepth = 0;
		for(int forLoop = 0; forLoop<charLength.length; forLoop ++)
		{
			if(charLength[forLoop] > maxDepth)
			{
				maxDepth = charLength[forLoop];
			}
		}
		System.out.println("4.     " + maxDepth);

		
		//Percentage taken up
		int totalSpaces =Integer.parseInt(data[0]) ;
		double percentage = numberOfXs/(double)totalSpaces;
		percentage = percentage*100.0;
		//rounding functions 
		NumberFormat nf = NumberFormat.getInstance();
		nf.setRoundingMode(RoundingMode.HALF_UP);
		nf.setMaximumFractionDigits(0);
		System.out.println("5.     " + nf.format(percentage) + "%");
		
	}
}
