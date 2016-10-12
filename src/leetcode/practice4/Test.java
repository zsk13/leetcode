package leetcode.practice4;

public class Test {
  public static void main(String[] args) {
    Solution1 s1 = new Solution1();
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    double res = s1.findMedianSortedArrays(nums1, nums2);
    System.out.println(res);
  }
}
