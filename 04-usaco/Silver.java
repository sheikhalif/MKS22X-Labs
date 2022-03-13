import java.io.*;
import java.util.*;

public class Silver{
  public static long solve(String filename){
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
      int firstRow = scanner1.nextInt()-1;
      int firstCol = scanner1.nextInt()-1;
      int lastRow = scanner1.nextInt()-1;
      int lastCol = scanner1.nextInt()-1;
      pasture[firstRow][firstCol] = 1;

      for (int r = 0; r < seconds; r++){
        int[][] newPasture = copyMatrix(pasture);
        System.out.println(matrixPrint(pasture));
        for (int a = 0; a < pasture.length; a++){
          for (int b = 0; b < pasture[0].length; b++){
            if (pasture[a][b] >= 1){
              if (valid(a+1, b, pasture)){
                newPasture[a+1][b]++;
              }
              if (valid(a-1, b, pasture)){
                newPasture[a-1][b]++;
              }
              if (valid(a, b+1, pasture)){
                newPasture[a][b+1]++;
              }
              if (valid(a, b-1, pasture)){
                newPasture[a][b-1]++;
              }
            }
          }
        }
        pasture = newPasture;
      }
      System.out.println(matrixPrint(pasture));
      return 1;
    }
    catch(FileNotFoundException e){
      return -1;
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

  public static int[][] copyMatrix(int[][] pasture){
    int[][] answer = new int[pasture.length][pasture[0].length];
    for (int i = 0; i < pasture.length; i++){
      for (int x = 0; x < pasture[0].length; x++){
        answer[i][x] = pasture[i][x];
      }
    }
    return answer;
  }

  public static boolean valid(int rowInput, int colInput, int[][] pasture){
    if (colInput >= pasture[0].length || colInput < 0 || rowInput >= pasture.length || rowInput < 0){
      return false;
    }
    if (pasture[rowInput][colInput] == -1){
      return false;
    }
    return true;
  }

  public static void main(String args[]){
    solve("Example2.txt");
  }
}
