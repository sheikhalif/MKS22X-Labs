import java.util.*;
import java.io.*;

public class MazeGenerator{
  public static void generate(char[][]maze, int startrow, int startcol){
    int numberOfOpenSquares = 0;
    if (startrow+1 < maze.length-1){
      if (maze[startrow+1][startcol] == ' ')numberOfOpenSquares++;
    }
    if (startrow-1 > 0){
      if (maze[startrow-1][startcol] == ' ')numberOfOpenSquares++;
    }
    if (startcol+1 < maze[0].length-1){
      if (maze[startrow][startcol+1] == ' ')numberOfOpenSquares++;
    }
    if (startcol-1 > 0){
      if (maze[startrow][startcol-1] == ' ')numberOfOpenSquares++;
    }
    if (maze[startrow][startcol] == ' ' || (startrow == 0 || startrow == maze.length-1 || startcol == 0 || startcol == maze[0].length-1) || numberOfOpenSquares > 1){
      //function to place end
    }
    else{
      maze[startrow][startcol] = ' ';
      Random rand = new Random();
      int rng = rand.nextInt(4);
      if (rng == 0){
        generate(maze, startrow+1, startcol);
        generate(maze, startrow-1, startcol);
        generate(maze, startrow, startcol+1);
        generate(maze, startrow, startcol-1);
      }
      if (rng == 1){
        generate(maze, startrow-1, startcol);
        generate(maze, startrow, startcol-1);
        generate(maze, startrow+1, startcol);
        generate(maze, startrow, startcol+1);
      }
      if (rng == 2){
        generate(maze, startrow, startcol-1);
        generate(maze, startrow, startcol+1);
        generate(maze, startrow-1, startcol);
        generate(maze, startrow+1, startcol);
      }
      if (rng == 3){
        generate(maze, startrow, startcol+1);
        generate(maze, startrow+1, startcol);
        generate(maze, startrow, startcol-1);
        generate(maze, startrow-1, startcol);
      }
    }
  }

  public static void main(String args[]){
    char[][] maze1 = mazeArrayMaker(14, 14);
    System.out.println(arrayToString(maze1));
    generate(maze1, 2, 3);
    System.out.println(arrayToString(maze1));
  }

  public static char[][] mazeArrayMaker(int rows, int cols){
    char[][] answer = new char[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int x = 0; x < cols; x++){
        answer[i][x] = '#';
      }
    }
    return answer;
  }

  public static String arrayToString(char[][] maze){
    String answer = "";
    int rows = maze.length;
    int cols = maze[0].length;
    for (int i = 0; i < rows; i++){
      for (int x = 0; x < cols; x++){
        answer+= maze[i][x];
      }
      answer+="\n";
    }
    return answer;
  }
}
