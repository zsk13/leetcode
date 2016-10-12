package leetcode.practice4;

public class Solution1 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    if ((length1 + length2) % 2 == 1) {
      return findKth(nums1, 0, length1, nums2, 0, length2, (length1 + length2 + 1) / 2);
    } else {
      return (findKth(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2)
          + findKth(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1)) / 2;
    }
  }

  public double findKth(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2,
      int k) {
    if (len1 > len2) {
      return findKth(nums2, start2, len2, nums1, start1, len1, k);
    }
    if (len1 == 0) {
      return nums2[start2 + k - 1];
    }
    if (k == 1) {
      int temp1 = nums1[start1];
      int temp2 = nums2[start2];
      return temp1 > temp2 ? temp2 : temp1;
    }
    int pa = k / 2 > len1 ? len1 : k / 2;
    int pb = k - pa;
    int na = nums1[start1 + pa - 1];
    int nb = nums2[start2 + pb - 1];
    if (na < nb) {
      return findKth(nums1, start1 + pa, len1 - pa, nums2, start2, len2, k - pa);
    } else if (na > nb) {
      if (len1 <= len2 - pb) {
        return findKth(nums1, start1, len1, nums2, start2 + pb, len2 - pb, k - pb);
      } else {
        return findKth(nums2, start2 + pb, len2 - pb, nums1, start1, len1, k - pb);
      }
    } else {
      return na;
    }
  }
}
