import java.util.*;
import java.io.*;

public class MazeGenerator{
  public static void generate(char[][]maze, int startrow, int startcol){
    //maze[startrow][startcol] = 'S';



    if (startrow+1 < maze.length && startcol+1 < maze[0].length){
      System.out.println(arrayToString(maze));
      if (maze[startrow][startcol] == '#'){
        maze[startrow][startcol] = ' ';
        Random rand = new Random();
        int rng = rand.nextInt(4);
        if (rng == 0 && startrow+2 < maze.length && startcol+1 < maze[0].length){
          generate(maze, startrow+1, startcol);
        }
        if (rng == 1 && startrow < maze.length && startcol+1 < maze[0].length){
          generate(maze, startrow-1, startcol);
        }
        if (rng == 2 && startrow < maze.length && startcol+2 < maze[0].length){
          generate(maze, startrow, startcol+1);
        }
        if (rng == 3 && startrow < maze.length && startcol < maze[0].length){
          generate(maze, startrow, startcol-1);
        }
      }
    }
  }

  public static void main(String args[]){
    char[][] maze1 = mazeArrayMaker(7, 7);
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
