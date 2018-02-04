package leetcode.practice32;

import java.util.Stack;

public class Solution1 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int[] arr = new int[s.length()];
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    continue;
                }
                int index = stack.pop();
                arr[i] = index>0? i-index+1 + arr[index-1] : i-index+1;
                max = Math.max(arr[i], max);
            }
        }
        return max;
    }
}
