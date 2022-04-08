import java.util.*;
import java.lang.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private Frontier deque;

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    if (deque.size() == 0){
      return true;
    }
    return false;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    int dequeSize = deque.size();
    for (int i = 0; i < dequeSize; i++){
      int[] mapPosition = deque.remove();
      map[mapPosition[0]][mapPosition[1]] = ASH;
      if (mapPosition[0] - 1 >= 0){
        if (map[mapPosition[0]-1][mapPosition[1]] == 2){
          map[mapPosition[0]-1][mapPosition[1]] = FIRE;
          int[] spreadTree = new int[]{mapPosition[0]-1, mapPosition[1]};
          deque.add(spreadTree);
        }
      }
      if (mapPosition[0] + 1 < map.length){
        if (map[mapPosition[0]+1][mapPosition[1]] == 2){
          map[mapPosition[0]+1][mapPosition[1]] = FIRE;
          int[] spreadTree = new int[]{mapPosition[0]+1, mapPosition[1]};
          deque.add(spreadTree);
        }
      }
      if (mapPosition[1] - 1 >= 0){
        if (map[mapPosition[0]][mapPosition[1]-1] == 2){
          int[] spreadTree = new int[]{mapPosition[0], mapPosition[1]-1};
          map[mapPosition[0]][mapPosition[1]-1] = FIRE;
          deque.add(spreadTree);
        }
      }
      if (mapPosition[1] + 1 < map[0].length){
        if (map[mapPosition[0]][mapPosition[1]+1] == 2){
          int[] spreadTree = new int[]{mapPosition[0], mapPosition[1]+1};
          map[mapPosition[0]][mapPosition[1]+1] = FIRE;
          deque.add(spreadTree);
        }
      }
      //System.out.println(toString());
    }
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
  }

  public static double averageOfNRuns(int n, int size, int density){
    double answer = 0;
    for (int i = 0; i < n; i++){
      Calender c1 = Calander.getInstance();
      Date d1 = c1.getTime();
      int startTime = d1.getTime();
      BurnTrees burn = new BurnTrees(size, size, density);
      Date d2 = c1.getTime();
      int endTime = d2.getTime();
      double time = endTime - startTime;
      answer+=time;
    }
    return answer / n;
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ )
      for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
           map[r][c]=2;
    start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    System.out.println(this.toString());
    deque = new Frontier();
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        int[] leftTree = {i, 0};
        deque.add(leftTree);
        map[i][0]=FIRE;
      }
    }
    ticks = 0;
  }



    public static void main(String[]args){
      /**
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


      int ans = b.animate(DELAY);//animate all screens
      System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
      **/
      for (int i = 1; i < 11; i++){
        System.out.println("Size: 100\nDensity: " + (i*0.1) + "\nAverage runtime: " + averageOfNRuns(30, 100, (i*0.1)));
      }
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }
}
