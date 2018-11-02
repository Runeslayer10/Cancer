/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cancer;

/**
 *
 * @author blhad3491
 */
public class Cancer {
public static String grid[][];
  public static int cancerSpot;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int row, col;
    //Create 2D array size 12 x 12
    grid = new String[15][15];

    //Fill the array with blanks
    for (row = 0; row < 15; row++) {
      for (col = 0; col < 15; col++) {
        grid[row][col] = "+";
      }
    }

    for (int i = 0; i < 70; i++) {
      row = (int) (Math.random() * 13 + 1);
      col = (int) (Math.random() * 13 + 1);
      grid[row][col] = "-";
    }
    displayGrid();
    
    for (row = 1; row < 14; row++){
        for (col = 1; col < 14; col++){
            if (grid[row][col].equals("-")) {
               Cancer(row,col);
               cancerSpot++;
            }
        }
        
    }
    System.out.println("The file had " + cancerSpot + " cancer spots in it.");
    System.out.println("The new grid is:");
    
    //Print out the new grid
    displayGrid();
    }
    
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



