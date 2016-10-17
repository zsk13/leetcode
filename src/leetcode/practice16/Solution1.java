package leetcode.practice16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length - 2;) {
      int end = nums.length - 1;
      for (int j = i + 1; j < nums.length - 1;) {
        int diff = target - nums[i] - nums[j] - nums[end];
        if (diff == 0) {
          return target;
        } else if (Math.abs(diff) < Math.abs(min)) {
          min = diff;
        }
        while (end - 1 >= 0 && nums[end - 1] == nums[end]) {
          end--;
        }
        end--;
        if (j >= end) {
          while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
            j++;
          }
          j++;
          end = nums.length - 1;
        }
      }
      while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
        i++;
      }
      i++;
    }
    return target - min;
  }
}
