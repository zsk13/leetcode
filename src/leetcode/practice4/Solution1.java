package leetcode.practice4;

public class Solution1 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    int total = length1 + length2;
    int first1 = 0;
    int second1 = length1;
    int first2 = 0;
    int second2 = length2;

    int tempMid1 = (first1 + second1) / 2;
    int tempMid2 = (first2 + second2) / 2;

    return 0;
  }
}
