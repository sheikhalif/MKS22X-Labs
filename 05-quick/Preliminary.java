import java.util.*;
import java.io.*;

public class Preliminary{
  public static int partition(int[] data, int start, int end){
    Random rand1 = new Random();
    int rng = rand1.nextInt(end-start+1) + start;
    //doing with another array for now. will change later
    int dataCopy[] = new int[data.length];
    dataCopy[0] = data[rng];
    int pivot = 0;
    int startCounter = start;
    int endCounter = end;
    for (int i = 0; i < end-start+1; i++){
      if (data[i] >= data[rng]){
        dataCopy[endCounter] = data[i];
        endCounter--;
      }
      else if (data[i] < data[rng]){
        dataCopy[startCounter] = data[i];
        startCounter++;
        dataCopy[pivot+1] = data[rng];
        pivot++;
      }
    }
    data = dataCopy;
    return pivot;
  }
  public static void main(String args[]){
    
  }
}
