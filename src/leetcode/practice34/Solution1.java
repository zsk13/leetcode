package leetcode.practice34;

public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        int l = 0;
        int h = nums.length-1;
        int mid;
        boolean none = false;
        while(true){
            mid = (l+h)/2;
            if(nums[mid]>target){
                h = mid - 1;
            }else if(nums[mid]<target){
                l = mid + 1;
            }else{
                break;
            }
            if(l>h){
                none = true;
                break;
            }
        }
        if(none){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int tempmid = mid;
        while(mid>0 && nums[mid-1]==target){
            mid--;
        }
        while(tempmid<nums.length-1 && nums[tempmid+1]==target){
            tempmid++;
        }
        result[0] = mid;
        result[1] = tempmid;
        return result;
    }
}
