package leetcode.practice3;

import java.util.HashSet;
import java.util.Set;

public class Practice3 {
  public int lengthOfLongestSubstring(String s) {
    int length = 0;
    for (int i = 0; i < s.length(); i++) {
      length = Math.max(length, lengthOfLongestSubStringFromIndex(i, s));
    }
    return length;
  }

  private int lengthOfLongestSubStringFromIndex(int i, String s) {
    Set<Character> set = new HashSet<Character>();
    for (int j = i; j < s.length(); j++) {
      if (set.contains(s.charAt(j))) {
        return j - i;
      }
      set.add(s.charAt(j));
    }
    return s.length() - i;
  }
}
