import java.util.*;
import java.io.*;

public class Merge{
  public static int[] merge(int[] left, int[] right){
    int leftCounter = 0;
    int rightCounter = 0;
    int[] answer = new int[left.length + right.length];
    for (int i = 0; i < (left.length +right.length); i++){
      if (leftCounter < left.length && rightCounter < right.length){
        if (left[leftCounter] > right[rightCounter]){
          answer[i] = left[leftCounter];
          leftCounter++;
          System.out.println("Inner loop");
        }
        else if (right[rightCounter] > left[leftCounter]){
          answer[i] = right[rightCounter];
          rightCounter++;
          System.out.println("Inner loop");
        }
      }
      else if (leftCounter >= left.length && rightCounter < right.length){
        answer[i] = right[rightCounter];
        rightCounter++;
        System.out.println("Left is maxxed");
      }
      else if (rightCounter >= right.length && leftCounter < left.length){
        answer[i] = left[leftCounter];
        leftCounter++;
        System.out.println("Right is maxxed");
      }
    }
    return answer;
  }

  public static void main(String args[]){
    int[] example1 = new int[]{1, 4, 6, 7, 12};
    int[] example2 = new int[]{2, 5, 6, 8, 10, 15};
    System.out.println(Arrays.toString(merge(example1, example2)));
  }
}
