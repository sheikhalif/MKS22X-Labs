//empty array should not work with partition
//sort should work with empty array

import java.util.*;
import java.io.*;

public class Quick{
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

  public static int quickSelect(int[] data, int k){
    int pivInd = -1;
    int start = 0;
    int end = data.length-1;
    while (pivInd != k){
      pivInd = partition(data, start, end);
      if (pivInd > k){
        end = pivInd - 1;
      }
      else if (pivInd < k){
        start = pivInd + 1;
      }
    }
    return data[pivInd];
  }

  public static boolean ordered (int[] data){
    boolean answer = true;
    for (int i = 1; i < data.length; i++){
      if (data[i-1] > data[i]){
        answer = false;
      }
    }
    return answer;
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length-1);
  }

  public static void quicksort(int[] data, int start, int end){
    if (!(start == end) && start>=0 && end < data.length && start <= end){
      int partition = partition(data, start, end);
      quicksort(data, start, partition-1);
      quicksort(data, partition+1, end);
    }
  }

  public static int[] arrayMakerRandom(int num){
    int[] answer = new int[num];
    Random rand = new Random();
    for (int i = 0; i < num; i++){
      int number = rand.nextInt(1000);
      answer[i] = number;
    }
    return answer;
  }
  public static int[] arrayMakerSame(int num){
    int[] answer = new int[num];
    Random rand = new Random();
    int number = rand.nextInt(1000);
    for (int i = 0; i < num; i++){
      answer[i] = number;
    }
    return answer;
  }

  public static int[] arrayMakerSorted(int num){
    int[] answer = new int[num];
    for (int i = 0; i < num; i++){
      answer[i] = i;
    }
    return answer;
  }
  public static int[] arrayMakerRevSorted(int num){
    int[] answer = new int[num];
    for (int i = 0; i < num; i++){
      answer[i] = num-i;
    }
    return answer;
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

    int[] example2 = new int[]{0, 0, 0, 0, 0, 0};
    System.out.println(partition(example2, 0, 4));
    System.out.println(Arrays.toString(example2));

    int[] example3 = new int[]{3, 11, 17, 24, 31, 43};
    System.out.println(partition(example3, 0, 5));
    System.out.println(Arrays.toString(example3));

    int[] example4 = new int[]{0, 12, 12, 12, 12, 0};
    System.out.println(partition(example4, 1, 4));
    System.out.println(Arrays.toString(example4));

    int[] example5 = new int[]{3, 11, 17, 24, 31, 43};
    int[] example6 = new int[]{12, 5, 15, 62, 12, 42, 5};
    System.out.println(quickSelect(example5, 0));
    System.out.println(quickSelect(example5, 1));
    System.out.println(quickSelect(example5, 2));
    System.out.println(quickSelect(example5, 3));
    System.out.println(quickSelect(example5, 4));
    System.out.println(quickSelect(example5, 5));
    System.out.println("Example 2");
    System.out.println(quickSelect(example6, 0));
    System.out.println(quickSelect(example6, 1));
    System.out.println(quickSelect(example6, 2));
    System.out.println(quickSelect(example6, 3));
    System.out.println(quickSelect(example6, 4));
    System.out.println(quickSelect(example6, 5));
    System.out.println(quickSelect(example6, 6));

    int[] example7 = new int[]{12, 5, 15, 62, 12, 42, 5};
    quicksort(example7);
    System.out.println(Arrays.toString(example7));

    int[] example8 = arrayMakerRandom(1000000);
    int[] example9 = arrayMakerRandom(1000000);
    int[] example10 = arrayMakerRandom(1000000);
    int[] example11 = arrayMakerRandom(40);
    int[] example12 = arrayMakerSame(40);
    int[] example13 = arrayMakerSorted(40);
    int[] example14 = arrayMakerRevSorted(40);
    quicksort(example8);
    System.out.println("Done with 1");
    quicksort(example9);
    System.out.println("Done with 2");
    quicksort(example9);
    System.out.println("Done with 3");
    quicksort(example11);
    System.out.println(Arrays.toString(example11));
    quicksort(example12);
    System.out.println(Arrays.toString(example12));
    quicksort(example13);
    System.out.println(Arrays.toString(example13));
    quicksort(example14);
    System.out.println(Arrays.toString(example14));
    System.out.println(partition(example12, 0, example12.length-1));
    **/
    int[] example15 = arrayMakerSorted(1000000);
    quicksort(example15);
    System.out.println("Done with 1");
    int[] example16 = arrayMakerSorted(1000000);
    quicksort(example16);
    System.out.println("Done with 2");
    int[] example17 = arrayMakerSorted(1000000);
    quicksort(example17);
    System.out.println("Done with 3");
  }
}
