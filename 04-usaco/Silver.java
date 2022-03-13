import java.io.*;
import java.util.*;

public class Silver{
  public static void solve(String filename){
    try{
      File obj = new File(filename);
      Scanner scanner1 = new Scanner(obj);
      int rows = scanner1.nextInt();
      int cols = scanner1.nextInt();
      int seconds = scanner1.nextInt();
      scanner1.nextLine();
      int[][] pasture = new int[rows][cols];
      for (int i = 0; i < rows; i++){
        String inputString = scanner1.nextLine();
        for (int x = 0; x < cols; x++){
          char inputChar = inputString.charAt(x);
          if (inputChar == '.'){
            pasture[i][x] = 0;
          }
          else{
            pasture[i][x] = -1;
          }
        }
      }
      System.out.println(matrixPrint(pasture));
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

  public static void main(String args[]){
    solve("Example2.txt");
  }
}
