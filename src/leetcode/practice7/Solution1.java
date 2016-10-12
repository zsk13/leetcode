package leetcode.practice7;

public class Solution1 {
  public int reverse(int x) {
    String input = x + "";
    char[] chin = input.toCharArray();
    int i = 0;
    int j = chin.length - 1;
    if (chin[0] != '-') {
      while (i < j) {
        char temp = chin[i];
        chin[i] = chin[j];
        chin[j] = temp;
        i++;
        j--;
      }
    } else {
      i = 1;
      while (i < j) {
        char temp = chin[i];
        chin[i] = chin[j];
        chin[j] = temp;
        i++;
        j--;
      }
    }
    String res = String.valueOf(chin);
    try {
      int resInt = Integer.parseInt(res);
      return resInt;
    } catch (Exception e) {
      return 0;
    }
  }
}
