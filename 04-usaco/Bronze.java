import java.io.*;
import java.util.*;

public class Bronze{
  public static long solve(String filename){
    try{
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
      for (int i = 0; i < numCommands; i++){
        int commandRow = scanner1.nextInt()-1;
        int commandCol = scanner1.nextInt()-1;
        int difference = scanner1.nextInt();
        int largestNum = -10000000;
        for (int a = 0; a < 3; a++){
          for (int b = 0; b < 3; b++){
            if (field[commandRow+a][commandCol+b] > largestNum){
              largestNum = field[commandRow+a][commandCol+b];
            }
          }
        }
        for (int a = 0; a < 3; a++){
          for (int b = 0; b < 3; b++){
            if (field[commandRow+a][commandCol+b] >= largestNum - difference){
              field[commandRow+a][commandCol+b] = largestNum - difference;
            }
          }
        }
      }

      for (int i = 0; i < field.length; i++){
        for (int x = 0; x < field[0].length; x++){
          if (waterLevel - field[i][x] > 0){
            field[i][x] = waterLevel - field[i][x];
          }
          else{
            field[i][x] = 0;
          }
        }
      }
      int answer = 0;
      for (int i = 0; i < field.length; i++){
        for (int x = 0; x < field[0].length; x++){
          answer+= field[i][x];
        }
      }
      return (answer*72*72);
    }
    catch (FileNotFoundException e){
      return -1;
    }
  }

  public static void main(String args[]){
    System.out.println(solve("Example1.txt"));
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
