package leetcode.practice30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int length = s.length();
        int num = words.length;
        int len = words[0].length();
        for (int i = 0; i < length - num * len + 1; i++) {
            HashMap<String,Integer> seen = new HashMap<>();
            int j = 0;
            while(j<num){
                String word = s.substring(i+j*len,i+(j+1)*len);
                if(counts.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    if(seen.get(word)>counts.get(word)){
                        break;
                    }
                    j++;
                }else{
                    break;
                }
            }
            if(j==num){
                results.add(i);
            }
        }
        return results;
    }
}
