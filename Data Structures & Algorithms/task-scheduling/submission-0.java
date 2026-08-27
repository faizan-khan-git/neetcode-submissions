class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(char task : tasks){
            frequencies[task - 'A']++;
        }

        // find max freq of any single task
        int maxFreq = 0;
        for(int f : frequencies){
            maxFreq = Math.max(maxFreq, f);
        }

        // count how many tasks share this max freq
        int maxCount = 0;
        for(int f : frequencies){
            if(f == maxFreq){
                maxCount++;
            }
        }

        // Calculate the minimum cycles based on the most frequent task(s)
        // Formula: (Max Frequency - 1) * (Cooldown Interval + 1) + Number of Max Frequency Tasks

        int minCycles = (maxFreq - 1) * (n + 1) + maxCount;

        // The result is either the calculated cycles (if idle time is needed) 
        // or the total number of tasks (if no idle time is needed)

        return Math.max(tasks.length, minCycles);
    }
}
