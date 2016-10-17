package leetcode.practice15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length - 2;) {
      find(list, nums, i + 1, -nums[i]);
      while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
        i++;
      }
      i++;
    }
    return list;
  }

  private void find(List<List<Integer>> result, int[] nums, int begin, int target) {
    int end = nums.length - 1;
    while (begin < end) {
      if (nums[begin] + nums[end] == target) {
        Integer[] temp = new Integer[] {-target, nums[begin], nums[end]};
        result.add(Arrays.asList(temp));
        while (begin + 1 < nums.length && nums[begin + 1] == nums[begin]) {
          begin++;
        }
        begin++;
        end = nums.length - 1;
      } else {
        while (end - 1 >= 0 && nums[end - 1] == nums[end]) {
          end--;
        }
        end--;
        if (begin >= end) {
          while (begin + 1 < nums.length && nums[begin + 1] == nums[begin]) {
            begin++;
          }
          begin++;
          end = nums.length - 1;
        }
      }
    }
  }
}
