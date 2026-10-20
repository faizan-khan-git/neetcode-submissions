class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int ans = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[left] <= nums[mid]){
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            }else{
                right = mid - 1;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}
