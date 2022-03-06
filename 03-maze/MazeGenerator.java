import java.util.*;
import java.io.*;

public MazeGenerator{
  public static void generate(char[][]maze, int startrow, int startcol){
    maze[startrow][startcol] = 'S';
    if (startrow+1 < maze.length && startcol+1 < maze[0].length){
      if (maze[startrow][startcol] == '#'){
        maze[startrow][startcol] = ' ';
        Random rand = new Random();
        int rng = rand.nextInt(5);
        if (rng == 0){
          generate(maze, startrow+1, startcol);
        }
        if (rng == 1){
          generate(maze, startrow-1, startcol);
        }
        if (rng == 2){
          generate(maze, startrow, startcol+1);
        }
        if (rng == 3){
          generate(maze, startrow, startcol-1);
        }
      }
    }
  }
}
