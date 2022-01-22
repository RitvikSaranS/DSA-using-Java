https://leetcode.com/problems/search-in-rotated-sorted-array
class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int m = -1;
        while(s <= e){
            m = s + (e - s)/2;
            if(nums[m] == target) return m;    // answer found at mid
            else if(nums[s] <= nums[m]){
                if(target < nums[m] && target >= nums[s]) e = m - 1; // answer to left sorted part
                else s = m + 1;
            }else if(nums[e] >= nums[m]){
                if(target > nums[m] && target <= nums[e]) s = m + 1; // answer to right sorted part
                else e = m - 1;
            }
        }
        return -1;   //if not found return -1
    }
}