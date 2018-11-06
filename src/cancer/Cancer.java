/*
 * Blake Hadaway
 * November 5th, 2018
 * This program searches for cancer cells (-) in a 15x15 grid (The subject) with (+) as healthy cells
 */

package cancer;
import java.io.*;
/**
 *
 * @author blhad3491
 */
public class Cancer {
public static String grid[][];
  public static int cancerSpot, cancerBlobNum;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        
        String myLine;
     
        // Reading the CancerFile.txt
        BufferedReader fileIn = new BufferedReader(new FileReader("CancerPatient1.txt"));

        int row, col;
    //Create 2D array size 15 x 15
    grid = new String[15][15];
    
    //reading the file and putting each charater into a element in the 2D array
    for (row = 0; row < 15; row++){
        myLine = fileIn.readLine();
        for(col = 0; col < 15; col++){
            grid[row][col] = "" + myLine.charAt(col);
        }
    }
    
    //displaying initial grid
    displayGrid();
    
    // this is checking every position to see if there is a cancer cell
    for (row = 1; row < 14; row++){
        for (col = 1; col < 14; col++){
            if (grid[row][col].equals("-")) {
               Cancer(row,col);
               cancerSpot++;
               cancerBlobNum++;
            }
        }
 
    }

    //this if statment is if there is only one cancer blob, so that it will print blob instead of blobs
    if(cancerBlobNum == 1){
    System.out.println("The file had " + cancerBlobNum + " cancer blob in it.");
    System.out.println("That " + cancerBlobNum + " blob consisted of " + (cancerSpot - 1) +
            " cancer cells.");
    System.out.println("The new grid is:");
    // this else statment is if there is any other number of blobs or cancer cells
    }else{
    System.out.println("The file had " + cancerBlobNum + " cancer blobs in it.");
    System.out.println("That " + cancerBlobNum + " blobs consisted of " + (cancerSpot - cancerBlobNum) +
            " cancer cells.");
    System.out.println("The new grid is:");
    }
    //Print out the new grid
    displayGrid();
    }
    
    // this is the recursive portion of the program, checking if there is any negatives 
    // around the first cancer cell that the program finds.
    public static void Cancer(int row, int col) {
    if (grid[row][col].equals("-")) {
      grid[row][col] = " ";
      cancerSpot++;
      Cancer(row - 1, col - 1);
      Cancer(row - 1, col);
      Cancer(row - 1, col + 1);
      Cancer(row, col - 1);
      Cancer(row, col + 1);
      Cancer(row + 1, col - 1);
      Cancer(row + 1, col);
      Cancer(row + 1, col + 1);
    }
  }

    
    // this is just displaying the grid line by line
  public static void displayGrid() {
    String output = "";
    for (int row = 0; row <= 14; row++) {
      
      for (int col = 0; col <= 14; col++) {
        output += grid[row][col];
      }
      output += "\n";
    }
    System.out.println(output);
  }
}



