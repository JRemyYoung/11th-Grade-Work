import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
import java.math.RoundingMode;
//Made by Remy Young

public class RemyYoungContest1 {
	//declare the public variables.
	public static int inputCount = 0;
	public static int milesNeededToTravel =0;
	public static char[] city = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
	public static int[] distCity = {450, 140, 125, 365, 250, 160, 380, 235, 320};
	public static char firstCity;
	public static int firstCityInt;
	public static char secondCity;
	public static int secondCityInt;
	public static int distanceTwoCity;
	public static String[] timeOne = new String[3];
	public static String[] timeTwo = new String[3];
	public static int intTimeOne;
	public static int intTimeTwo;
	public static int comparitiveOne;
	public static int comparitiveTwo;
	public static int goFirst;
	public static int hoursGoneBy;
	public static float minituesGoneBy;
	public static int currentSpeed;
	public static int distanceLeft;
	public static int hoursLeft;
	public static int differenceBetweenHours;
	public static String[] data;
	public static void main(String args[]){
		//loop for five times
		while(inputCount < 5)
		{
			CleanUp();
			Scanner input = new Scanner(System.in);
			data = input.nextLine().split(", ");
			CalculateTravDis();
			//System.out.println("distance between cities" + distanceTwoCity);
			CalculateWhichTimeSmaller();
			//System.out.println("difference between ours" +differenceBetweenHours);
			//System.out.println("which time smaller" +goFirst);
			CalculateTime();
			NumberFormat nf = NumberFormat.getInstance();
			nf.setRoundingMode(RoundingMode.HALF_EVEN);
			nf.setMinimumIntegerDigits(2);
			nf.setMaximumFractionDigits(0);
			System.out.println(hoursGoneBy+":"+nf.format(minituesGoneBy));

			inputCount ++;
		}
	}
	//reset after each go around
	public static void CleanUp()
	{
		milesNeededToTravel =0;
		hoursGoneBy = 0;
		minituesGoneBy =0;
		distanceLeft = 0;
		distanceTwoCity= 0;
		goFirst = 0;
		currentSpeed = 0;
		hoursLeft = 0;
	}
	//calculate the time it takes to actually go around
	public static void CalculateTime()
	{
		int calculatedMins = 0;
		distanceLeft = distanceTwoCity;
		hoursLeft = differenceBetweenHours;
		while(distanceLeft>0)
		{
			while(hoursLeft>0)
			{
				if(distanceLeft <=0)
				{
					break;
				}
				else if(goFirst == 1)
				{
					currentSpeed = Integer.parseInt(timeOne[2]);
				}
				else if(goFirst == 2)
				{
					currentSpeed = Integer.parseInt(timeTwo[2]);
				}
				//System.out.println("start speed " + currentSpeed);
				if(currentSpeed != 0)
				{
					if(distanceLeft/currentSpeed >0)
					{
						distanceLeft = distanceLeft - currentSpeed;
						if(goFirst == 1)
						{
							hoursGoneBy ++;
						}
						//System.out.println(" Hour Count " + hoursGoneBy);
					}
					else
					{
						CalculateMinutes();
						calculatedMins = 1;
					}
				}
				hoursLeft --;
			}
			if(calculatedMins == 1)
			{
				break;
			}
			currentSpeed = Integer.parseInt(timeOne[2]) + Integer.parseInt(timeTwo[2]);
			if(distanceLeft/currentSpeed >0)
			{
				distanceLeft = distanceLeft - currentSpeed;
				//System.out.println(" distanceLeft full Throttle " + distanceLeft);
				hoursGoneBy ++;
				//System.out.println(" Hour Count " + hoursGoneBy);
			}
			else
			{
				CalculateMinutes();
			}
		}
	}
	//calculate the minutes
	public static void CalculateMinutes()
	{
		//System.out.println("Distance that is Left" +distanceLeft);
		//System.out.println("current speed" +currentSpeed);
		minituesGoneBy = ((float)distanceLeft) / (float)currentSpeed;
		minituesGoneBy = minituesGoneBy *60;
		distanceLeft =0;
	}
	//find which car leaves first
	public static void CalculateWhichTimeSmaller()
	{
		timeOne[0] = data[2];
		timeOne[1] = data[3];
		timeOne[2] = data[6];
		//System.out.println(timeOne[1]);
		if(timeOne[1].equals("AM"))
		{
			//System.out.println("HI THERE");
			if(Integer.parseInt(timeOne[0]) == 12)
			{
				intTimeOne = 0;
			}
			else{
				intTimeOne =Integer.parseInt(timeOne[0]);
			}
		}
		else{
			if(Integer.parseInt(timeOne[0]) == 12)
			{
				intTimeOne =12;
			}
			else{
				intTimeOne = Integer.parseInt(timeOne[0]) + 12;
			}
		}
		//System.out.println("Time one" +intTimeOne);

		timeTwo[0] = data[4];
		timeTwo[1] = data[5];
		timeTwo[2] = data[7];

		if(timeTwo[1].equals("AM"))
		{
			if(Integer.parseInt(timeTwo[0]) == 12)
			{
				intTimeTwo = 0;
			}
			else{
				intTimeTwo = Integer.parseInt(timeTwo[0]);
			}
		}
		else{
			if(Integer.parseInt(timeTwo[0]) == 12)
			{
				intTimeTwo =12;
			}
			else{
				intTimeTwo = Integer.parseInt(timeTwo[0]) + 12;
			}
		}
		//System.out.println("Time two" +intTimeTwo);
		if(intTimeOne> intTimeTwo)
		{

			comparitiveOne = intTimeOne - intTimeTwo;
			comparitiveTwo = (intTimeTwo +24) - intTimeOne;
			if(comparitiveOne<comparitiveTwo)
			{
				differenceBetweenHours = comparitiveOne;
				goFirst = 2;
			}
			else if(comparitiveTwo<=comparitiveOne)
			{
				differenceBetweenHours = comparitiveTwo;
				goFirst = 1;
			}

		}
		else if(intTimeTwo>= intTimeOne)
		{

			comparitiveOne = intTimeTwo - intTimeOne;
			comparitiveTwo = (intTimeOne +24) - intTimeTwo;
			if(comparitiveOne<comparitiveTwo)
			{
				differenceBetweenHours = comparitiveOne;
				goFirst = 1;
			}
			else if(comparitiveTwo<=comparitiveOne)
			{
				differenceBetweenHours = comparitiveTwo;
				goFirst = 2;
			}

		}




	}
	public static void CalculateTravDis()
	{
		for(int i = 0; i<city.length; i++)
		{
			if(data[0].charAt(0) == city[i])
			{
				firstCity = city[i];
				firstCityInt = i;

				break;
			}
		}
		for(int i = 0; i<city.length; i++)
		{
			if(data[1].charAt(0) == city[i])
			{
				secondCity = city[i];
				secondCityInt = i;
				break;
			}
		}
		//make sure that it is both for bigger and less opposite and right
		if(secondCityInt > firstCityInt)
		{
			for(int i = 0;i<(Math.abs(secondCityInt - firstCityInt));i++)
			{
				int currentSpot  = firstCityInt + i;
				distanceTwoCity = distanceTwoCity + distCity[currentSpot];
				//need the case in which it is backwards
			}
			//find the distance and add the distances inbetween
		}
		else if(firstCityInt > secondCityInt)
		{
			for(int i = 0;i<(Math.abs(secondCityInt - firstCityInt));i++)
			{
				int currentSpot  = secondCityInt + i;
				distanceTwoCity = distanceTwoCity + distCity[currentSpot];
				//need the case in which it is backwards
			}
			//find the distance and add the distances inbetween
		}
		else if(firstCityInt == secondCityInt)
		{
			distanceTwoCity = 0;
		}

	}

}
