import java.util.*;
import java.io.*;

public class Preliminary{
  public static int partition(int[] data, int start, int end){
    Random rand1 = new Random();
    int rng = rand1.nextInt(end-start+1) + start;
    //doing with another array for now. will change later
    int dataCopy[] = new int[end-start+1];
    System.out.println(data[rng]);
    dataCopy[0] = data[rng];
    int pivot = 0;
    int startCounter = 0;
    int endCounter = end-start;
    for (int i = 0; i < end-start; i++){

      if (data[i+start] >= data[rng]){
        dataCopy[endCounter] = data[i+start];
        endCounter--;
      }
      else if (data[i+start] < data[rng]){
        dataCopy[startCounter] = data[i+start];
        startCounter++;
        dataCopy[pivot+1] = data[rng];
        pivot++;
      }
      System.out.println("Step " + i);
      System.out.println(Arrays.toString(dataCopy));
    }
    data = dataCopy;
    return pivot;
  }
  public static void main(String args[]){
    int[] example1 = new int[]{0, 0, 0, 32, 51, 57, 64, 12, 12, 0, 0};
    System.out.println(partition(example1, 3, 8));
    System.out.println(Arrays.toString(example1));
  }
}
