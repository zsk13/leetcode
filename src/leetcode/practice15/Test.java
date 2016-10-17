package leetcode.practice15;

import java.util.List;

public class Test {

  public static void main(String[] args) {
    Solution1 s1 = new Solution1();
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> list = s1.threeSum(nums);
    System.out.println(list);
  }

}
