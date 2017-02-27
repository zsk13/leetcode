package leetcode.practice20;

import java.util.Stack;

public class Solution1 {
  public boolean isValid(String s) {
    Stack stack = new Stack();
    stack.push('s');
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '[':
          stack.push(c);
          break;
        case ']':
          if (stack.pop().equals('[')) {
          } else {
            return false;
          }
          ;
          break;
        case '{':
          stack.push(c);
          break;
        case '}':
          if (stack.pop().equals('{')) {
          } else {
            return false;
          }
          ;
          break;
        case '(':
          stack.push(c);
          break;
        case ')':
          if (stack.pop().equals('(')) {
          } else {
            return false;
          }
          ;
          break;
      }
    }
    if (stack.size() == 1) {
      return true;
    } else {
      return false;
    }
  }
}
