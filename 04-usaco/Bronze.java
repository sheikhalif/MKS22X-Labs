import java.io.*;
import java.util.*;

public class Bronze{
  public static void solve(String filename) throws FileNotFoundException{
    File obj = new File(filename);
    Scanner scanner1 = new Scanner(obj);
    int rows = scanner1.nextInt();
    int cols = scanner1.nextInt();
    int waterLevel = scanner1.nextInt();
    int numCommands = scanner1.nextInt();
    int[][] field = new int[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int x = 0; x < cols; x++){
        field[i][x] = scanner1.nextInt();
      }
    }
    System.out.println("Rows: " + rows);
    System.out.println("Cols: " + cols);
    System.out.println("Water level: " + waterLevel);
    System.out.println("Num commands: " + numCommands);
    System.out.println("Matrix:");
    System.out.println(matrixPrint(field));
  }

  public static void main(String args[]){
    try{
      solve("Example1.txt");
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }

  }

  public static String matrixPrint(int[][] x){
    String answer = "";
    for (int i = 0; i < x.length; i++){
      for (int j = 0; j < x[0].length; j++){
        answer+= (x[i][j] + " ");
      }
      answer+= "\n";
    }
    return answer;
  }
}
