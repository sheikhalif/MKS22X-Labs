public class Classwork{
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

  public static splitArray(int[] nums, int sub1, int sub2, int start){
    if (sub1 == sub2 && start == nums.length-1){
      return true;
    }
    else{
      if (start < nums.length){
        return ((splitArray(nums, sub1+nums[start], sub2, start+1)) || splitArray(nums, sub1, sub2+nums[start], start1));
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
