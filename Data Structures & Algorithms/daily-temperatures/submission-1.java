class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            int currTemp = temperatures[i];

            while(!stack.isEmpty() && currTemp > temperatures[stack.peek()]){
                int prevDayIdx = stack.pop();

                result[prevDayIdx] = i - prevDayIdx;
            }
            stack.push(i);
        }

        return result;
    }
}
