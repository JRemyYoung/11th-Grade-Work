import java.util.Scanner;


public class ACSLContest4RemyYoung {
  public static int[][] ThreeVarBin = {{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}, {1, 0, 0, 0}, {1, 0, 1, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}};
  public static int[][] FiveVarBin = {{0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 1, 0}, {1, 1, 0, 0, 0}, {1, 1, 0, 1, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 0}}; 
  public static int[][] ThreeVarBinSimplified;
  public static int[][] FiveVarBinSimplified;
  public static int indexZeroLeftOff;
  public static int indexOneLeftOff;
  public static int indexTwoLeftOff;
  public static int indexThreeLeftOff;
  public static int ZeroOnes = 0;
  public static int OneOnes = 0;
  public static int TwoOnes = 0;
  public static int ThreeOnes = 0;
  public static int[][] ThreeIndexZero;
  public static int[][] ThreeIndexOne;
  public static int[][] ThreeIndexTwo;
  public static int[][] ThreeIndexThree;
  public static int[][] ThreeIndexZeroPhaseOne;
  public static int[][] ThreeIndexOnePhaseOne;
  public static int[][] ThreeIndexTwoPhaseOne;
  public static int[][] ThreeIndexThreePhaseOne;
  public static boolean Match = false;
  public static int copyLeftOff= 0;
  public static int copyLeftOffIndex = 0;
  public static String[] data;
  public static int counter=0;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner input = new Scanner(System.in);
    data = input.nextLine().split(", ");
    data[data.length-1] = "0";
    int[] localDataInt = new int[data.length-1];
    int[][] ThreeVarBinSimplified = new int[localDataInt.length][4];
    for(int i = 0; i<data.length-1; i++)
    {
      localDataInt[i] = Integer.parseInt(data[i]);
    }
    if(counter < 3)
    {
      for(int i = 0; i<localDataInt.length; i++)
      {
        ThreeVarBin[localDataInt[i]][3] = 1;
      }
      for(int i = 0; i<ThreeVarBin.length; i++)
      {
        if(ThreeVarBin[i][3] == 1)
        {
          int NumberOfOne = 0;

          for(int q =0; q<4; q++) 
          {
          //  System.out.println("hello");
            ThreeVarBinSimplified[copyLeftOff][q] = ThreeVarBin[i][q]; //store the ones with a one int eh three var bin.
            if(ThreeVarBin[i][q] == 1)
            {
              NumberOfOne ++; // count how many ones are in the actually variable
            }
          }
          if(NumberOfOne == 0)
          {
            ZeroOnes ++;
          }
          if(NumberOfOne == 1)
          {
            OneOnes ++;
          }
          if(NumberOfOne == 2)
          {
            TwoOnes ++;
          }
          if(NumberOfOne == 3)
          {
            ThreeOnes ++;
          }
          ThreeVarBinSimplified[copyLeftOff][3] = NumberOfOne;
          copyLeftOff ++;
        }
      }
     // System.out.println(copyLeftOff);
      int[][] ThreeIndexZero = new int[ZeroOnes][4];
      int[][] ThreeIndexOne = new int[OneOnes][4];
      int[][] ThreeIndexTwo = new int[TwoOnes][4];
      int[][] ThreeIndexThree = new int[ThreeOnes][4];
      int[][] ThreeIndexZeroPhaseOne = new int[ZeroOnes][4];
      int[][] ThreeIndexOnePhaseOne = new int[OneOnes][4];
      int[][] ThreeIndexTwoPhaseOne = new int[TwoOnes][4];
      int[][] ThreeIndexThreePhaseOne = new int[ThreeOnes][4];
      for(int i = 0; i<copyLeftOff; i++)
      {
        if(ThreeVarBinSimplified[i][3] == 0)
        {
          for(int q =0; q<4;q++)
          {
            ThreeIndexZero[indexZeroLeftOff][q] = ThreeVarBinSimplified[i][q];
          }
          indexZeroLeftOff ++;
        }
        if(ThreeVarBinSimplified[i][3] == 1)
        {
          for(int q =0; q<4;q++)
          {
            ThreeIndexOne[indexOneLeftOff][q] = ThreeVarBinSimplified[i][q];
          }
          indexOneLeftOff ++;
        }
        if(ThreeVarBinSimplified[i][3] == 2)
        {
          for(int q =0; q<4;q++)
          {
            ThreeIndexTwo[indexTwoLeftOff][q] = ThreeVarBinSimplified[i][q];
          }
          indexTwoLeftOff ++;
        }
        if(ThreeVarBinSimplified[i][3] == 3)
        {
          for(int q =0; q<4;q++)
          {
            ThreeIndexThree[indexThreeLeftOff][q] = ThreeVarBinSimplified[i][q];
          }
          indexThreeLeftOff ++;
        }
      }

      SortWithinIndex(indexZeroLeftOff, ThreeIndexZero, ThreeIndexZeroPhaseOne);
      SortWithIndexAbove(indexZeroLeftOff, indexOneLeftOff, ThreeIndexZero, ThreeIndexOne,ThreeIndexZeroPhaseOne); 
      //One
      SortWithinIndex(indexOneLeftOff, ThreeIndexOne, ThreeIndexOnePhaseOne);
      SortWithIndexAbove(indexOneLeftOff, indexTwoLeftOff, ThreeIndexOne, ThreeIndexTwo,ThreeIndexOnePhaseOne);
      //Two
      SortWithinIndex(indexTwoLeftOff, ThreeIndexTwo, ThreeIndexTwoPhaseOne);
      SortWithIndexAbove(indexTwoLeftOff, indexThreeLeftOff, ThreeIndexTwo, ThreeIndexThree,ThreeIndexTwoPhaseOne);
      //Three
      SortWithinIndex(indexThreeLeftOff, ThreeIndexThree, ThreeIndexThreePhaseOne);
      //no above for Three because there is no index above.
      
      // print the function
      PrintTheFunction(ThreeIndexZeroPhaseOne);
      PrintTheFunction(ThreeIndexOnePhaseOne);
      PrintTheFunction(ThreeIndexTwoPhaseOne);
      PrintTheFunction(ThreeIndexThreePhaseOne);

      //phase 2, combine those that need to be combined



    }
  }
  public static void SortWithinIndex(int indexOrigLeftOff, int[][]ThreeIndexOrig, int[][]ThreeIndexOrigPhaseOne)
  {
    int[][]ThreeIndexOrigPhaseOneCopy = new int[1][3];
    boolean localMatch = false;
    if(indexOrigLeftOff>1) /// change this
    {
      int placeKeeper = 0;
      int numberNotMatches = 0;
      for(int i = 0; i<indexOrigLeftOff; i++) ///
      {
        for(int h = i+1; h<indexOrigLeftOff; h++)///
        {
          int placeKeeper2 = 0;
          for(int q = 0; q< 3; q++)
          {
            if(ThreeIndexOrig[i][q] == ThreeIndexOrig[h][q]&&localMatch == false)///
            {
              localMatch = true; // tage it as true
              q = 0;
              placeKeeper2 = 0;
            }
            if(localMatch = true)
            {

              if(ThreeIndexOrig[i][q] == ThreeIndexOrig[h][q])///
              {
                ThreeIndexOrigPhaseOneCopy[0][placeKeeper2] = ThreeIndexOrig[i][q];///
                placeKeeper2++;
              }
              else
              {
                ThreeIndexOrigPhaseOneCopy[0][placeKeeper2] = 9;///
                placeKeeper2++;
                numberNotMatches++;
              }
            }
          }
          if(numberNotMatches==1 && localMatch == true)
          {
            for(int w = 0; w<3; w++)
            {
              ThreeIndexOrigPhaseOne[placeKeeper][w] = ThreeIndexOrigPhaseOneCopy[0][w];
              localMatch = false;
              placeKeeper++;
            }
          }
          else{
            placeKeeper++;
          }
          numberNotMatches = 0;
          
        }
      
      }
    }
  }
  public static void SortWithIndexAbove(int indexOrigLeftOff, int indexUpLeftOff, int[][] ThreeIndexOrig, int[][] ThreeIndexUp, int[][]ThreeIndexOrigPhaseOne)
  {
    boolean localMatch = false;
    if(indexUpLeftOff>1) /// change this
    {
      int placeKeeper = 0;
      int notSame = 0;
      for(int i = 0; i<indexOrigLeftOff; i++) ///
      {
        for(int h = i+1; h<indexUpLeftOff; h++)///
        {
          int placeKeeper2 = 0;
          for(int q = 0; q< 3; q++)
          {
            if(ThreeIndexOrig[i][q] == ThreeIndexUp[h][q])///
            {
              localMatch = true; // tage it as true
              notSame++;
            }
           
            }
          if(localMatch = true && notSame == 1)
          {
            for(int q= 0; q<3; q++)
            {
            if(ThreeIndexOrig[i][q] == ThreeIndexUp[h][q])///
            {
              ThreeIndexOrigPhaseOne[placeKeeper][placeKeeper2] = ThreeIndexOrig[i][q];///
              placeKeeper2++;
            }
            else
            {
              ThreeIndexOrigPhaseOne[placeKeeper][placeKeeper2] = 9;///
              placeKeeper2++;
            }
            }
          }
          notSame = 0;
          localMatch = false;
          placeKeeper++;
        }
      }
    }
  }
  public static void PhaseTwo(int[][] ThreeIndexOrigPhaseOne, int[][] ThreeIndexUpPhaseOne)
  {
    
  }
  public static void PrintTheFunction(int[][] TwoDArray)
  {
    for(int i = 0; i<TwoDArray.length; i++)
    {
      for(int q= 0; q<4; q++)
      {
        System.out.println(TwoDArray[i][q]);
      }
    }
  }

}
