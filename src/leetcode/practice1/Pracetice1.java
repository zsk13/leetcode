package leetcode.practice1;

import java.util.HashMap;

public class Pracetice1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    Integer des = null;
    for (int i = 0; i < nums.length; i++) {
      map.put(target - nums[i], nums[i]);
    }
    boolean isMid = true;
    for (int i = 0; i < nums.length; i++) {
      des = map.get(nums[i]);
      if (des != null && des.intValue() * 2 != target) {
        isMid = false;
        break;
      }
      des = null;
    }
    if (isMid) {
      des = new Integer(target / 2);
    }
    int[] result = new int[2];
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == des.intValue() || nums[i] == target - des.intValue()) {
        result[j] = i;
        j++;
      }
    }
    return result;
  }
}
