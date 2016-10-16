package leetcode.practice46;

import java.util.List;

public class Test {
  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] a = {1, 2, 3};
    List<List<Integer>> i = s.permute(a);
    System.out.println(i);
  }
}
