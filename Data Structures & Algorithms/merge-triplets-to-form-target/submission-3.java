class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundFirst = false;
        boolean foundSecond = false;
        boolean foundThird = false;

        for(int[] t : triplets){

            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
                continue;
            }

            if(t[0] == target[0]) foundFirst = true;
            if(t[1] == target[1]) foundSecond = true;
            if(t[2] == target[2]) foundThird = true;

            if(foundFirst && foundSecond && foundThird){
                return true;
            }
        }

        return foundFirst && foundSecond && foundThird;
    }
}
