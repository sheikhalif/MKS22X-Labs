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

  public static boolean splitArray(int[] nums, int sub1, int sub2, int start){
    if (nums.length == 0)return true;
    else if (start == nums.length){
      return (sub1 == sub2);
    }
    else{
      return ((splitArray(nums, sub1+nums[start], sub2, start+1)) || splitArray(nums, sub1, sub2+nums[start], start+1));
    }
  }

  public static void main(String args[]){
    int[] arr1 = {5,2,3, 4, 4};
    int[] arr2 = {12, 4, 11, 53};
    int[] arr3 = {2, 2, 10, 10, 1, 1};
    System.out.println(splitArray(arr1, 0, 0, 0));
    System.out.println(splitArray(arr2, 0, 0, 0));
    System.out.println(splitArray(arr3, 0, 0, 0));
  }
}
