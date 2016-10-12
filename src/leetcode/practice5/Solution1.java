package leetcode.practice5;

public class Solution1 {
  public String longestPalindrome(String s) {
    char[] ch = new char[s.length() * 2 + 1];
    for (int i = 0; i < s.length(); i++) {
      ch[2 * i + 1] = s.charAt(i);
      ch[2 * i] = '*';
    }
    ch[2 * s.length()] = '*';
    int max = 1;
    int j = 1;
    int temp = 0;
    for (int i = 1; i < ch.length - 1; i++) {
      while (i - j >= 0 && i + j <= ch.length - 1 && ch[i - j] == ch[i + j]) {
        j++;
      }
      temp = max > (j - 1) ? temp : i;
      max = max > (j - 1) ? max : (j - 1);
      j = 1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = temp - max; i <= temp + max; i++) {
      if (ch[i] != '*') {
        sb.append(ch[i]);
      }
    }
    return sb.toString();
  }
}
