package leetcode.practice10;

public class Test {
  public static void main(String[] args) {
    Solution1 s1 = new Solution1();
    System.out.println(s1.isMatch("aa", "a") == false);
    System.out.println(s1.isMatch("aa", "aa") == true);
    System.out.println(s1.isMatch("aaa", "aa") == false);
    System.out.println(s1.isMatch("aa", "a*") == true);
    System.out.println(s1.isMatch("aa", ".*") == true);
    System.out.println(s1.isMatch("ab", ".*") == true);
    System.out.println(s1.isMatch("aab", "c*a*b") == true);
    System.out.println(s1.isMatch("aab", ".*a") == true);
  }
}
