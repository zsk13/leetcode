package leetcode.practice17;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
  String[] help = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    int len = digits.length();
    int[] num = new int[len];
    for (int i = 0; i < len; i++) {
      num[i] = digits.charAt(i) - '0';
    }
    List<String> result = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    if (len == 0) {
      return result;
    }
    for (int j = 0; j < help[num[0]].length(); j++) {
      sb.append(help[num[0]].charAt(j));
      helper(result, num, sb);
      sb.deleteCharAt(sb.length() - 1);
    }

    return result;
  }

  private void helper(List<String> result, int[] num, StringBuilder sb) {
    if (sb.length() == num.length) {
      result.add(sb.toString());
      return;
    }
    int index = sb.length();
    for (int i = 0; i < help[num[index]].length(); i++) {
      sb.append(help[num[index]].charAt(i));
      helper(result, num, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
