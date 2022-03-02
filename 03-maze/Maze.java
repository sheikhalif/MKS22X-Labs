import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public Maze(String filename) throws FileNotFoundException{
    int rows = 0;
    int cols = 0;
    File mazeFile = new File(filename);
    Scanner text = new Scanner(mazeFile);
    while (text.hasNextLine()){
      rows++;
      String nextLine = text.nextLine();
      cols = nextLine.length();
    }
    maze = new char[rows][cols];
    Scanner text2 = new Scanner(mazeFile);
    for (int i = 0; i < rows; i++){
      String nextLine = text2.nextLine();
      for (int x = 0; x < cols; x++){
        maze[i][x] = nextLine.charAt(x);
      }
    }
  }

  public static void main(String args[]){
    try{
      Maze maze1 = new Maze("Maze1.txt");
      System.out.println(maze1.toString());
      System.out.println(maze1.solve(5, 1));
      System.out.println(maze1.toString());
    }
    catch(FileNotFoundException e){
      System.out.println("File not found");
    }

  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString(){
    String answer = "";
    for (int i = 0; i < maze.length; i++){
      for (int x = 0; x < maze[0].length; x++){
        answer += maze[i][x];
      }
      answer += '\n';
    }
    return answer;
  }

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol);

  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    //System.out.println(this.toString());
    if (maze[row][col] == 'E'){
      int answer = 0;
      for (int i = 0; i < maze.length; i++){
        for (int x = 0; x < maze[0].length; x++){
          if (maze[i][x] == '@'){
            System.out.println(answer);
            answer++;
          }
        }
      }
      return answer;
    }
    else if (maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '@'){
      return -1;
    }
    else{
      maze[row][col] = '@';
      int S = solve(row+1, col);
      if (S > -1){
        return 1+S;
      }
      int N = solve(row-1, col);
      if (N > -1){
        return 1+N;
      }
      int E = solve(row, col+1);
      if (E > -1){
        return 1+E;
      }
      int W = solve(row, col-1);
      if (W > -1){
        return 1+W;
      }
      maze[row][col] = '.';
      return -1;
    }

  }
}
