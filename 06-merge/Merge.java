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
          answer[i] = right[rightCounter];
          rightCounter++;
        }
        else if (right[rightCounter] >= left[leftCounter]){
          answer[i] = left[leftCounter];
          leftCounter++;
        }
      }
      else if (leftCounter >= left.length && rightCounter < right.length){
        answer[i] = right[rightCounter];
        rightCounter++;
      }
      else if (rightCounter >= right.length && leftCounter < left.length){
        answer[i] = left[leftCounter];
        leftCounter++;
      }
    }
    return answer;
  }

  public static void main(String args[]){
    int[] example1 = new int[]{1, 4, 6, 7, 12};
    int[] example2 = new int[]{2, 5, 6, 8, 10, 15};
    System.out.println(Arrays.toString(merge(example1, example2)));
    int[] example3 = new int[]{1, 2, 5, 7, 9, 14, 16, 17, 19, 31, 35, 38, 53, 59, 82, 96};
    int[] example4 = new int[]{3, 7, 8, 12, 53, 59, 62, 65, 68, 74, 79, 89, 93};
    System.out.println(Arrays.toString(merge(example3, example4)));
  }
}
