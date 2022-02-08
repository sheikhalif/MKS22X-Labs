public class partialSum{
  public static boolean partialSum(int start, int[] arr, int targetValue){
    if (targetValue == 0){
      return true;
    }
    else{
      if (start < arr.length-1){
        partialSum(start+1, arr, targetValue-arr[start+1]);
        partialSum(start+1, arr, targetValue);
      }
    }
    return false;
  }

  public static void main(String args[]){
    int[] arr1 = {2,4,8};
    int[] arr2 = {2,4,8};
    System.out.println(partialSum(0, arr1,10));
    System.out.println(partialSum(0, arr2,14));
  }
}
