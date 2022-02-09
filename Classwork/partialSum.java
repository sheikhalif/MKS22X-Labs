public class partialSum{
  public static boolean partialSum(int start, int[] arr, int targetValue){
    if (targetValue == 0){
      return true;
    }
    else{
      if (start < arr.length){
        return ((partialSum(start+1, arr, targetValue-arr[start])) || (partialSum(start+1, arr, targetValue)));
      }
    }
    return false;
  }

  public static void main(String args[]){
    int[] arr1 = {2,4,8};
    int[] arr2 = {3,4,5};
    System.out.println(partialSum(0, arr1,10));
    System.out.println(partialSum(0, arr2,14));
  }
}
