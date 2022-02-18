import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{
  //method to read file
  public static int[] getValuesFromFile{
    File text = new File (filename);
    int rows = 0;
    int col = 0;
    //gets the number of rows
    while (text.hasNextLine()){
      rows++;
    }

    //gets number of cols
    String nextLine = text.nextLine();
    col = nextLine.string();

    //sets size of int array
    int[][] answer = new int[rows][col];

    //uses current line before looping through the rest of the lines
    for (int a = 0; a<cols; a++){
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

  //main - check if file is valid
  public static void main(String args[]){
    int[] nums = new int[0];
    try{
      nums = getValuesFromFile("Numbers.csv");
    }
    catch(FileNotFoundException e){
      System.out.println("File is not valid")
    }
  }
}
