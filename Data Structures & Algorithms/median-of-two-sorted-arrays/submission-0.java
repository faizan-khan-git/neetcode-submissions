class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int total = m + n;

        int half = (total+1)/2;

        while(left <= right){
            int i = left + (right-left)/2;
            int j = half - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
            }else if(Aleft > Bright){
                right = i-1;
            }else{
                left = i+1;
            }
        }
        throw new IllegalArgumentException();
    }
}
