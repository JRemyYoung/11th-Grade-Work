import java.util.Arrays;
import java.util.Scanner;

//Made by John Remy Young
// 4/17/15
// CS3A



public class RemyYoungContest3 {
	public static int [][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0} ,  {0, 1, 2, 3, 4, 5, 6, 7, 0}, {0, 8, 9, 10, 11, 12, 13, 14, 0}, {0, 15, 16, 17, 18, 19, 20, 21, 0}, {0, 22, 23, 24, 25, 26, 27, 28, 0},{0, 29, 30, 31, 32, 33, 34, 35, 0}, {0, 36, 37, 38, 39, 40, 41, 42, 0}, {0, 43, 44, 45, 46, 47, 48, 49, 0} ,{0, 0, 0, 0, 0, 0, 0, 0, 0}};
	public static int [] gridSingle = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};
	public static String [] data;
	public static int [] dataInt;
	public static int [] boundaryToken;
	public static int plusToken;
	public static int plusTokenRow;
	public static int plusTokenColumn;
	public static int xToken;
	public static int xTokenRow;
	public static int xTokenColumn;
	public static boolean plusTokenFound = false;
	public static boolean xTokenFound = false;
	public static int[] pathPossibilities;
	public static int[] escapePossibilities = new int[49];
	public static int[] escapePossibilitiesRow = new int[49];
	public static int[] escapePossibilitiesColumn = new int[49];
	public static int leftOff=0;
	public static int leftOffEscape =0;
	public static int zeroFound =0;
	public static int escapeSameColumn =0;
	public static int escapeSameRow = 0;
	public static boolean similarColumn = true;
	public static boolean similarRow = true;
	public static boolean similarDiag= true;
	public static boolean noPaths = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int w = 0; w<5; w++)
		{
			leftOff = 0;
			leftOffEscape = 0;
			escapeSameColumn =0;
			escapeSameRow = 0;
			similarColumn = true;
			similarRow = true;
			similarDiag= true;
			noPaths = false;
			xToken =0;
			xTokenRow = 0;
			xTokenColumn = 0;
			plusToken =0;
			plusTokenRow = 0;
			plusTokenColumn = 0;
			escapePossibilities = new int[49];
			escapePossibilitiesRow = new int[49];
			escapePossibilitiesColumn = new int[49];
			xTokenFound = false;
			plusTokenFound = false;
			final String [] data;
			final int [] dataInt;
			final int[]boundaryToken;
			int[][]grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0} ,  {0, 1, 2, 3, 4, 5, 6, 7, 0}, {0, 8, 9, 10, 11, 12, 13, 14, 0}, {0, 15, 16, 17, 18, 19, 20, 21, 0}, {0, 22, 23, 24, 25, 26, 27, 28, 0},{0, 29, 30, 31, 32, 33, 34, 35, 0}, {0, 36, 37, 38, 39, 40, 41, 42, 0}, {0, 43, 44, 45, 46, 47, 48, 49, 0} ,{0, 0, 0, 0, 0, 0, 0, 0, 0}};
			
			
		Scanner input = new Scanner(System.in);
		data = input.nextLine().split(", ");
		data[data.length-1] = "0";
		int[] localDataInt = new int[data.length];
		for(int i = 0; i<data.length; i++)
		{
			localDataInt[i] = Integer.parseInt(data[i]);
		}
		plusToken =Integer.parseInt(data[0]);
		xToken = Integer.parseInt(data[1]);
		boundaryToken = Arrays.copyOfRange(localDataInt, 2, localDataInt.length-1);
		//find location of the plus token.
		for(int row = 0; row<9; row ++)
		{
			for(int column = 0; column<9; column++)
			{
				if(grid[row][column] == plusToken)
				{
					plusTokenRow = row;
					plusTokenColumn = column;
					plusTokenFound = true;
					grid[row][column] = 99;
					break;
				}
			}
			if(plusTokenFound == true)
			{
				break;
			}
		}
		//find location of x token
		for(int row = 0; row<9; row ++)
		{
			for(int column = 0; column<9; column++)
			{
				if(grid[row][column] == xToken)
				{
					xTokenRow = row;
					xTokenColumn = column;
					xTokenFound = true;
					grid[row][column] = 0;
					break;
				}
			}
			if(xTokenFound == true)
			{
				break;
			}
		}
		//find set locations of the boundary tokens to 0.
		for(int i = 0; i<boundaryToken.length; i++)
		{
			for(int row = 0; row<9; row ++)
			{
				for(int column = 0; column<9; column++)
				{
					if(grid[row][column] == boundaryToken[i])
					{
						grid[row][column] = 0;
					}
				}
			}
		}

		//PRINT THE GRID
		/*
		for(int row = 0; row<9; row ++)
		{
			for(int column = 0; column<9; column++)
			{
				System.out.print(grid[row][column] + " ");
			}
			System.out.println("");
		}
		*/

		int[] newPathPossibilities = new int[49];
		 newPathPossibilities = new int[49];

		//check to see where the plus token can go
		if(grid[plusTokenRow+1][plusTokenColumn-1]!=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow+1][plusTokenColumn-1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow+1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn-1;
			leftOffEscape++;
		}
		if(grid[plusTokenRow +1][plusTokenColumn] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow+1][plusTokenColumn];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow+1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn;
			leftOffEscape++;
		}
		if(grid[plusTokenRow +1][plusTokenColumn+1] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow+1][plusTokenColumn+1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow+1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn+1;
			leftOffEscape++;
		}
		if(grid[plusTokenRow][plusTokenColumn-1] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow][plusTokenColumn-1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn-1;
			leftOffEscape++;
		}
		if(grid[plusTokenRow][plusTokenColumn+1] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow][plusTokenColumn+1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn+1;
			leftOffEscape++;
		}
		if(grid[plusTokenRow -1][plusTokenColumn-1] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow-1][plusTokenColumn-1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow-1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn-1;
			leftOffEscape++;
		}
		if(grid[plusTokenRow -1][plusTokenColumn] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow-1][plusTokenColumn];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow-1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn;
			leftOffEscape++;
		}
		if(grid[plusTokenRow -1][plusTokenColumn+1] !=0)
		{
			escapePossibilities[leftOffEscape] = grid[plusTokenRow-1][plusTokenColumn+1];
			escapePossibilitiesRow[leftOffEscape]= plusTokenRow-1;
			escapePossibilitiesColumn[leftOffEscape] = plusTokenColumn+1;
			leftOffEscape++;
		}
		
		//System.out.println("Escape Possibilities:");
		//PrintArray(escapePossibilities);
		//System.out.println("END POSSIBILITIES");
		//System.out.println(leftOffEscape);
		if(leftOffEscape == 0) //just move where ever you can
		{
		 //up
		 for(int i =1; i<10; i++)
		 {
		   if(grid[xTokenRow +i][xTokenColumn] != 0 &&grid[xTokenRow +i][xTokenColumn] != 99)
		   {
		     newPathPossibilities[leftOff] = grid[xTokenRow +i][xTokenColumn];
		     leftOff ++;
		   }
		   else
		   {
		     break;
		   }
		 }
		 //down
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow -i][xTokenColumn] != 0 &&grid[xTokenRow -i][xTokenColumn] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow -i][xTokenColumn];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //left
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow][xTokenColumn+i] != 0 &&grid[xTokenRow][xTokenColumn+i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow][xTokenColumn+i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //right
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow][xTokenColumn-i] != 0 &&grid[xTokenRow][xTokenColumn-i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow][xTokenColumn-i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //diagonal down
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow+i][xTokenColumn+i] != 0 &&grid[xTokenRow+i][xTokenColumn+i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow+i][xTokenColumn+i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //diagonal up
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow-i][xTokenColumn-i] != 0 &&grid[xTokenRow-i][xTokenColumn-i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow-i][xTokenColumn-i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //diagonal up right
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow+i][xTokenColumn-i] != 0 &&grid[xTokenRow+i][xTokenColumn-i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow+i][xTokenColumn-i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		 //diagonal down left OTHER DIRECTION
		 for(int i =1; i<10; i++)
     {
       if(grid[xTokenRow-i][xTokenColumn+i] != 0 &&grid[xTokenRow-i][xTokenColumn+i] != 99)
       {
         newPathPossibilities[leftOff] = grid[xTokenRow-i][xTokenColumn+i];
         leftOff ++;
       }
       else
       {
         break;
       }
     }
		}
		if(leftOffEscape != 0)
		{
		for(int i = 0; i<leftOffEscape;i++)
		{
			if(i == 0)
			{
				escapeSameColumn = escapePossibilitiesColumn[i];
				escapeSameRow = escapePossibilitiesRow[i];
			}
		
			else
			{
				if(escapeSameColumn != escapePossibilitiesColumn[i]&& similarColumn == true)
				{
					similarColumn = false;
				}
				if(escapeSameRow != escapePossibilitiesRow[i]&& similarRow == true)
				{
					similarRow = false;
				}
				if(Math.abs(escapeSameRow - escapePossibilitiesRow[i]) != 1 &&Math.abs(escapeSameColumn - escapePossibilitiesColumn[i]) != 1)
				{
					similarDiag = false;
				}
			}
		}
		if(similarColumn == true || similarRow == true)
		{
			if(xTokenColumn == escapeSameColumn)
			{
				if(xTokenRow<plusTokenRow)
				{
					for(int i = xTokenRow+1; i<plusTokenRow; i++)
					{
						newPathPossibilities[leftOff+(i-(xTokenRow+1))] = grid[i][plusTokenColumn];
					}
				}
				if(xTokenRow>plusTokenRow)
				{
					for(int i = plusTokenRow+1; i<xTokenRow; i++)
					{
						newPathPossibilities[leftOff+(i-(plusTokenRow+1))] = grid[i][plusTokenColumn];
					}
				}
				if(xTokenRow>escapeSameRow)
				{
				 // System.out.println("HELLO");
				  for(int i =1; i<10; i++)
			     {
			       if(grid[xTokenRow -i][xTokenColumn] != 0 &&grid[xTokenRow -i][xTokenColumn] != 99)
			       {
			         newPathPossibilities[leftOff] = grid[xTokenRow -i][xTokenColumn];
			         leftOff ++;
			       }
			       else
			       {
			         break;
			       }
			     }
				}
			}
			if(xTokenRow == escapeSameRow)
			{
				if(xTokenColumn<plusTokenColumn)
				{
					for(int i = xTokenColumn+1; i<plusTokenColumn; i++)
					{
						newPathPossibilities[leftOff+(i-(xTokenColumn+1))] = grid[plusTokenRow][i];
					}
				}
				if(xTokenColumn>plusTokenColumn)
				{
					for(int i = plusTokenColumn+1; i<xTokenColumn; i++)
					{
						newPathPossibilities[leftOff+(i-(plusTokenColumn+1))] = grid[plusTokenRow][i];
					}
				}
			}
		}
		//System.out.println(similarDiag);
		//System.out.println(similarColumn);
		//System.out.println(similarRow);
		if(similarDiag == true)
		{
			if(Math.abs(xTokenColumn - escapeSameColumn) == Math.abs(xTokenRow - escapeSameRow))
			{
				if(xTokenColumn>escapeSameColumn && xTokenRow<escapeSameRow)
				{
					int localP = 1;
					for(int i = xTokenColumn;grid[xTokenRow+(localP)][xTokenColumn-(localP)] != 0 &&grid[xTokenRow+(localP)][xTokenColumn-(localP)] != 99 ; i--)
					{
						//System.out.println("OPTION 1");
						newPathPossibilities[leftOff +(localP-1)] = grid[xTokenRow+(localP)][xTokenColumn-(localP)];
					localP ++;
					}
				}
				if(xTokenColumn>escapeSameColumn && xTokenRow>escapeSameRow)
				{
				  
					int localP = 1;
					for(int i = xTokenColumn;grid[xTokenRow-(localP)][xTokenColumn-(localP)]!=0 && grid[xTokenRow-(localP)][xTokenColumn-(localP)]!= 99; i--)
					{
						//System.out.println("OPTION 2");
						newPathPossibilities[leftOff +(localP-1)] = grid[xTokenRow-(localP)][xTokenColumn-(localP)];
					localP ++;
					}
				}
				if(xTokenColumn<escapeSameColumn && xTokenRow<escapeSameRow)
				{
					int localP = 1;
					for(int i = xTokenColumn;grid[xTokenRow+(localP)][xTokenColumn+(localP)]!=0 && grid[xTokenRow+(localP)][xTokenColumn+(localP)]!=99; i++)
					{
						//System.out.println("OPTION 3");
						newPathPossibilities[leftOff +localP-1] = grid[xTokenRow+(localP)][xTokenColumn+(localP)];
					localP ++;
					}
				}
				if(xTokenColumn<escapeSameColumn && xTokenRow>escapeSameRow)
				{
					int localP =1;
					for(int i = xTokenColumn;grid[xTokenRow-(localP)][xTokenColumn+(localP)]!=0 && grid[xTokenRow-(localP)][xTokenColumn+(localP)]!=99; i--)
					{
						//System.out.println("OPTION 4");
						newPathPossibilities[leftOff +(localP-1)] = grid[xTokenRow-(localP)][xTokenColumn+(localP)];
					localP++;
					}	
				}
			}
		}
		}
/*
		//Find the paths
		//same column
		if(xTokenColumn == plusTokenColumn && plusTokenRow>xTokenRow)
		{
			if((grid[plusTokenRow][plusTokenColumn-1] ==0&&grid[plusTokenRow][plusTokenColumn+1] ==0))
			{
				if(grid[plusTokenRow-1][plusTokenColumn -1] == 0 && grid[plusTokenRow-1][plusTokenColumn +1] ==0)
				{
					if(grid[plusTokenRow +1][plusTokenColumn -1] == 0 && grid[plusTokenRow +1][plusTokenColumn] ==0 && grid[plusTokenRow +1][plusTokenColumn +1] ==0)
					{
						System.out.println("Got Here");
						if(xTokenRow<plusTokenRow)
						{
							for(int i = xTokenRow+1; i<plusTokenRow; i++)
							{
								newPathPossibilities[leftOff+(i-(xTokenRow+1))] = grid[i][plusTokenColumn];
							}
						}
						if(xTokenRow>plusTokenRow)
						{
							for(int i = plusTokenRow+1; i<xTokenRow; i++)
							{
								newPathPossibilities[leftOff+(i-(xTokenRow+1))] = grid[i][plusTokenColumn];
							}
						}
					}
				}
			}
		}
		if(xTokenColumn == plusTokenColumn && plusTokenRow<xTokenRow)
		{
			if((grid[plusTokenRow][plusTokenColumn-1] ==0&&grid[plusTokenRow][plusTokenColumn+1] ==0))
			{
				if(grid[plusTokenRow-1][plusTokenColumn -1] == 0 && grid[plusTokenRow-1][plusTokenColumn +1] ==0 && grid[plusTokenRow -1][plusTokenColumn] ==0 )
				{
					if(grid[plusTokenRow +1][plusTokenColumn -1] == 0 && grid[plusTokenRow +1][plusTokenColumn +1] ==0)
					{
						System.out.println("Got Here");
						if(xTokenRow<plusTokenRow)
						{
							for(int i = xTokenRow+1; i<plusTokenRow; i++)
							{
								newPathPossibilities[leftOff+(i-(xTokenRow+1))] = grid[i][plusTokenColumn];
							}
						}
						if(xTokenRow>plusTokenRow)
						{
							for(int i = plusTokenRow+1; i<xTokenRow; i++)
							{
								newPathPossibilities[leftOff+(i-(xTokenRow+1))] = grid[i][plusTokenColumn];
							}
						}
					}
				}
			}
		}

		//same row
		if(xTokenRow == plusTokenRow)

*/

			//clean up the array for print
			for(int q = 0; q<newPathPossibilities.length;q++)
			{
				if(newPathPossibilities[q] == 0)
				{
					zeroFound =q;
					if(zeroFound == 0)
					{
						noPaths = true;
					}
					break;
				}
			}
		pathPossibilities = Arrays.copyOfRange(newPathPossibilities, 0, zeroFound);
		if(noPaths == false)
		{
			for(int p = 0; p<pathPossibilities.length;p++)
			{

				if(p == pathPossibilities.length -1)
				{
					System.out.print(pathPossibilities[p]);
					System.out.println("");
				}
				else
				{
					System.out.print(pathPossibilities[p] + ", ");
				}
			}
		}
		if(noPaths == true)
		{
			System.out.println("NONE");
		}
		//System.out.println("Xtoken row and column" + xTokenRow +" "+ xTokenColumn);
		//System.out.println("Xtoken row and column" + plusTokenRow +" "+ plusTokenColumn);
		}
		}
	public static void PrintArray(int[]array) {
		for(int q = 0; q<array.length;q++)
		{
			if(array[q] == 0)
			{
				break;
			}
			else{
				System.out.println(array[q] + ", ");
			}
		}
	}
	

}
