package leetcode.practice15;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i; j < nums.length - 1; j++) {
        if (set.contains(-(nums[i] + nums[j]))) {

        }
      }
    }
    return null;
  }
}
