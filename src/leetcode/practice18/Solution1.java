package leetcode.practice18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int begin = 0;
    int beginNum = 0;
    while (begin < nums.length - 3) {
      beginNum = nums[begin];
      if (beginNum * 4 > target) {
        break;
      }
      List<List<Integer>> tempList = threeSum(begin + 1, nums, target - beginNum);
      for (List<Integer> l : tempList) {
        ArrayList<Integer> tl = new ArrayList<Integer>();
        tl.add(beginNum);
        tl.addAll(l);
        list.add(tl);
      }
      while (beginNum == nums[begin] && begin < nums.length - 1) {
        begin++;
      }
    }
    return list;
  }

  public List<List<Integer>> threeSum(int start, int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int begin = start;
    int beginNum = 0;
    while (begin < nums.length - 2) {
      beginNum = nums[begin];
      if (beginNum * 3 > target) {
        break;
      }
      List<List<Integer>> tempList = twoSum(begin + 1, nums, target - beginNum);
      for (List<Integer> l : tempList) {
        ArrayList<Integer> tl = new ArrayList<Integer>();
        tl.add(beginNum);
        tl.addAll(l);
        list.add(tl);
      }
      while (beginNum == nums[begin] && begin < nums.length - 1) {
        begin++;
      }
    }
    return list;
  }

  public List<List<Integer>> twoSum(int start, int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int begin = start;
    int end = nums.length - 1;
    int beginNum = 0;
    int endNum = 0;
    while (begin < end) {
      beginNum = nums[begin];
      endNum = nums[end];
      if (beginNum + endNum == target) {
        list.add(Arrays.asList(beginNum, endNum));
        while (nums[begin] == beginNum && begin < end) {
          begin++;
        }
        while (nums[end] == endNum && begin < end) {
          end--;
        }
      } else if (beginNum + endNum > target) {
        end--;
      } else {
        begin++;
      }
    }
    return list;
  }
}
