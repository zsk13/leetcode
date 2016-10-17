package leetcode.practice8;

public class Solution1 {
  public int myAtoi(String str) {
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    int specIndex = 0;
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

      } else {
        specIndex = i;
        break;
      }
    }
    if (str.charAt(0) >= '0' && str.charAt(0) <= '9' || str.charAt(0) == '-'
        || str.charAt(0) == '+') {
      if (specIndex != 0) {
        str = str.substring(0, specIndex);
      }
    } else {
      return 0;
    }
    try {
      return parseInt(str, 10);
    } catch (Exception e) {
      return 0;
    }
  }

  public int parseInt(String s, int radix) throws NumberFormatException {
    /*
     * WARNING: This method may be invoked early during VM initialization before IntegerCache is
     * initialized. Care must be taken to not use the valueOf method.
     */

    if (s == null) {
      throw new NumberFormatException("null");
    }

    if (radix < Character.MIN_RADIX) {
      throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
    }

    if (radix > Character.MAX_RADIX) {
      throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
    }

    int result = 0;
    boolean negative = false;
    int i = 0, len = s.length();
    int limit = -Integer.MAX_VALUE;
    int multmin;
    int digit;

    if (len > 0) {
      char firstChar = s.charAt(0);
      if (firstChar < '0') { // Possible leading "+" or "-"
        if (firstChar == '-') {
          negative = true;
          limit = Integer.MIN_VALUE;
        } else if (firstChar != '+') throw new NumberFormatException("");

        if (len == 1) // Cannot have lone "+" or "-"
          throw new NumberFormatException("");
        i++;
      }
      multmin = limit / radix;
      while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        digit = Character.digit(s.charAt(i++), radix);
        if (digit < 0) {
          throw new NumberFormatException("");
        }
        if (result < multmin) {
          // return MAX_VALUE instead of throw a exception, modify for the case "2147483648" of
          // practice8
          return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        result *= radix;
        if (result < limit + digit) {
          // return MAX_VALUE instead of throw a exception, modify for the case "2147483648" of
          // practice8
          return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        result -= digit;
      }
    } else {
      throw new NumberFormatException("");
    }
    return negative ? result : -result;
  }
}
