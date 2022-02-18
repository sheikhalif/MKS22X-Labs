import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{
  //method to read file
  public static int[][] getValuesFromFile(String filename){
    try{
      System.out.println("Method triggered");
      File textOld = new File (filename);
      Scanner text = new Scanner(textOld);
      int rows = 0;
      int col = 0;
      //gets the number of rows
      while (text.hasNextLine()){
        rows++;
        System.out.println("Rows: " + rows);
      }
      System.out.println("Rows: " + rows);

      //gets number of cols
      String nextLine = text.nextLine();
      col = nextLine.length();
      System.out.println("Cols: " + col);

      //sets size of int array
      int[][] answer = new int[rows][col];

      //uses current line before looping through the rest of the lines
      for (int a = 0; a<col; a++){
        answer[0][a] = nextLine.charAt(a);
      }

      //put in all the values into 2d character array
      for (int i = 1; i < rows; i++){
        nextLine = text.nextLine();
        for (int x = 0; x < col; x++){
          answer[i][x] = nextLine.charAt(x);
        }
      }

      return answer;
    }
    catch(FileNotFoundException e){
      int[][] answer = new int[0][0];
      System.out.println("File name is not valid");
      return answer;
    }

  }

  //main - check if file is valid
  public static void main(String args[]){
    int[][] nums = new int[0][0];
    try{
      nums = getValuesFromFile("Maze1.txt");
      System.out.println(nums.toString());
    }
    catch(Exception e){
      System.out.println("File is not valid");
    }
  }
}
