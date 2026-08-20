class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for(int pile : piles){
            right = Math.max(right, pile);
        }

        int result = right;

        while(left <= right){
            int k = left + (right - left)/2;
            long hours = 0;

            for(int pile : piles){
                hours += Math.ceil((double) pile/k);
            }

            if(hours <= h){
                result = k;
                right = k-1;
            }else{
                left = k+1;
            }
        }
        return result;
    }
}
