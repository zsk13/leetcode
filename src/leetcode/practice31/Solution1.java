package leetcode.practice31;

import java.util.Arrays;

public class Solution1 {
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while(index>0&&nums[index]<=nums[index-1]){
           index--; 
        }
        if(index==0){
            Arrays.sort(nums);
            return;
        }
        int largeIndex = index;
        while(largeIndex<nums.length && nums[largeIndex]>nums[index-1]){
            largeIndex++;
        }
        largeIndex--;
        int temp = nums[largeIndex];
        nums[largeIndex] = nums[index-1];
        nums[index-1] = temp;
        Arrays.sort(nums,index,nums.length);
        return;
    }
}
