package leetcode.practice49;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> list = new ArrayList<List<String>>();
    Map<Integer, Integer> hash2index = new HashMap<Integer, Integer>();
    int maxIndex = 0;
    for (int i = 0; i < strs.length; i++) {
      int hash = hashcode(strs[i]);
      if (hash2index.containsKey(hash)) {
        int index = hash2index.get(hash);
        list.get(index).add(strs[i]);
      } else {
        ArrayList<String> l = new ArrayList<String>();
        l.add(strs[i]);
        list.add(l);
        hash2index.put(hash, maxIndex);
        maxIndex++;
      }
    }
    return list;
  }

  private int hashcode(String s) {
    char[] ch = s.toCharArray();
    ArrayList<Character> list = new ArrayList<Character>();
    for (int i = 0; i < ch.length; i++) {
      list.add(ch[i]);
    }
    Collections.sort(list);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
    }
    return sb.toString().hashCode();
  }
}
