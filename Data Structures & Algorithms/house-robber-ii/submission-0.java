class Solution {
    private int helper(int[] nums, int start, int end){
        int n = nums.length;

        int[] dp = new int[n-1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i = start + 2, j = 2; i<=end; i++, j++){
            dp[j] = Math.max(dp[j-1], dp[j-2] + nums[i]);
        }

        return dp[n-2];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }
}
