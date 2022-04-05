import java.util.*;
public class Frontier{
  private ArrayDeque<int[]> frontier;
  public Frontier(){
  }
  public int size(){
    return frontier.size();
  }
  public void add(int[]location){
    frontier.add(location);
  }
  public int[] remove(){
    int[] answer = frontier.pollLast();
    return answer;
  }
}
