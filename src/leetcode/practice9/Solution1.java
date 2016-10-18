package leetcode.practice9;

public class Solution1 {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x < 10) {
      return true;
    }
    int num = 0;
    int y = x;
    while (y != 0) {
      y = y / 10;
      num++;
    }
    while (num >= 2) {
      int first = (int) (x / (int) (Math.pow(10, num - 1)));
      int last = x % 10;
      if (first != last) {
        return false;
      } else {
        x = x % (int) (Math.pow(10, num - 1));
        x = x / 10;
        num -= 2;
      }
    }
    return true;
  }
}
