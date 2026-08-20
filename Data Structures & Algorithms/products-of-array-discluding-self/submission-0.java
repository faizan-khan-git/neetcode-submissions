class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1;
        for(int i = 0; i<n; i++){
            output[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for(int i = n-1; i>=0; i--){
            output[i] *= postfix;
            postfix *= nums[i];
        }

        return output;
    }
}  
