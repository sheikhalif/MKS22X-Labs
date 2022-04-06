import java.util.*;
public class Frontier{
  private ArrayDeque<int[]> list;
  public Frontier(){
    list = new ArrayDeque<int[]>();
  }
  public int size(){
    return list.size();
  }
  public void add(int[]location){
    list.addLast(location);
  }
  public int[] remove(){
    int[] answer = list.pollFirst();
    return answer;
  }
}
