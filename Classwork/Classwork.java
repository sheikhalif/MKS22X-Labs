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

  public static boolean groupSum6(int start, int[] nums, int target){
    if (start == nums.length){
      if (target == 0)return true;
      else{
        return false;
      }
    }
    else{
      if (nums[start] == 6){
        return (groupSum6(start+1, nums, target-6));
      }
      else{
        return ((groupSum6(start+1, nums, target-nums[start])) || (groupSum6(start+1, nums, target)));
      }
    }
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (target == 0)return true;
    else if (start >= nums.length)return false;
    else{
      return ((groupNoAdj(start+2, nums,target-nums[start])) || (groupNoAdj(start+1,nums, target)));
    }
  }

  public static boolean splitOdd10(int[] nums, int sub1, int sub2, int start) {
    if (nums.length == 0)return false;
    else if (start == nums.length){
      return (((sub1 % 10 == 0) && (sub2 % 2 == 1)) || ((sub2 % 10 == 0) && (sub1 % 2 == 1)));
    }
    else{
      return ((splitOdd10(nums, sub1+nums[start], sub2, start+1)) || splitOdd10(nums, sub1, sub2+nums[start], start+1));
    }
  }

  public static boolean split53(int[] nums, int sub1, int sub2, int start){
    if (nums.length == 0)return true;
    else if (start == nums.length){
      return (sub1 == sub2);
    }
    else{
      if (nums[start] % 3 == 0)return split53(nums, sub1+nums[start], sub2, start+1);
      else if (nums[start] % 5 == 0) return split53(nums, sub1, sub2+nums[start], start+1);
      else{
        return ((split53(nums, sub1+nums[start], sub2, start+1)) || split53(nums, sub1, sub2+nums[start], start+1));
      }
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
