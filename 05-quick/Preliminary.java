import java.util.*;
import java.io.*;

public class Preliminary{
  public static int partition(int[] data, int start, int end){
    Random rand1 = new Random();
    int rng = rand1.nextInt(end-start+1) + start;
    //doing with another array for now. will change later
    int dataCopy[] = new int[end-start+1];
    dataCopy[0] = data[rng];
    int pivot = 0;
    int startCounter = 0;
    int endCounter = end-start;
    int buffer = 1;
    boolean coinFlip = true;
    for (int i = 0; i < end-start+1; i++){
      if (buffer == 1 && data[i+start] == data[rng]){
        buffer--;
      }
      else if (i > 0 && data[i+start] == data[i+start-1]){
        if (coinFlip){
          dataCopy[endCounter] = data[i+start];
          endCounter--;
          dataCopy[pivot] = data[rng];
          coinFlip = false;
        }
        else{
          dataCopy[startCounter] = data[i+start];
          startCounter++;
          dataCopy[pivot+1] = data[rng];
          pivot++;
          coinFlip = true;
        }
      }
      else if (data[i+start] >= data[rng]){
        dataCopy[endCounter] = data[i+start];
        endCounter--;
        dataCopy[pivot] = data[rng];
      }
      else if (data[i+start] < data[rng]){
        dataCopy[startCounter] = data[i+start];
        startCounter++;
        dataCopy[pivot+1] = data[rng];
        pivot++;
      }
    }
    for (int a = start; a < end+1; a++){
      if (data[a] != dataCopy[a-start]){
        data[a] = dataCopy[a-start];
      }
    }
    return pivot+start;
  }
  public static void main(String args[]){
    /**
    int[] example1 = new int[]{0, 0, 0, 32, 51, 57, 64, 12, 12, 0, 0};
    System.out.println(partition(example1, 3, 8));
    System.out.println(Arrays.toString(example1));
    int [] data = new int[] {4,3,2,1,0};
    System.out.println("Original: "+Arrays.toString(data));
    int pivot = partition( data, 0, 4);
    System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();
    **/

    int[] example2 = new int[]{0, 0, 0, 0, 0, 0};
    System.out.println(partition(example2, 0, 4));
    System.out.println(Arrays.toString(example2));

    int[] example3 = new int[]{3, 11, 17, 24, 31, 43};
    System.out.println(partition(example3, 0, 5));
    System.out.println(Arrays.toString(example3));


  }
}
