package leetcode.practice33;

public class Solution1 {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int l = 0;
        int h = nums.length-1;
        while(l<h){
            int mid = (l+h)/2;
            if(nums[mid]>nums[h]) 
                l=mid+1;
            else 
                h=mid;
        }
        int s = l;
        if(s==0){
            l=0;
            h=nums.length-1;
        }else{
            if(target<=nums[nums.length-1]){
                l=s;
                h=nums.length-1;
            }else{
                l=0;
                h=s;
            }
        }
        while(l<=h){
            int mid=(l+h)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return -1;
    }
}
