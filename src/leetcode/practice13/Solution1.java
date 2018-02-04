package leetcode.practice13;

import java.util.HashMap;

public class Solution1 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        char before = 'I';
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            int n = map.get(c);
            if(n<map.get(before)){
                res = res - n;
            }else{
                res = res + n;
            }
            before = c;
        }
        return res;
    }
}
