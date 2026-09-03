class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currGas = 0;
        int startIdx = 0;

        for(int i = 0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];

            currGas += gas[i] - cost[i];

            if(currGas < 0){
                startIdx = i + 1;
                currGas = 0;
            }
        }

        if(totalGas < totalCost){
            return -1;
        }

        return startIdx;
    }
}
