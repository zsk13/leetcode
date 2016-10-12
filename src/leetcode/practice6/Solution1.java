package leetcode.practice6;

public class Solution1 {
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    char[][] res = new char[numRows][s.length() / 2 + 1];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < (s.length() / 2 + 1); j++) {
        res[i][j] = '*';
      }
    }
    char[] ch = s.toCharArray();
    int m = 0;
    int n = 0;
    boolean down = true;
    for (int i = 0; i < ch.length; i++) {
      res[m][n] = ch[i];
      if (down && m < numRows - 1) {
        m++;
      } else {
        m--;
        n++;
      }
      if (m == numRows - 1) {
        down = false;
      }
      if (m == 0) {
        down = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < (s.length() / 2 + 1); j++) {
        if (res[i][j] != '*') {
          sb.append(res[i][j]);
        }
      }
    }
    return sb.toString();
  }
}
