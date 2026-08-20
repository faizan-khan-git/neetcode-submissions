class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(int i = 0; i<=nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = bucket.length -1; i>=0 && index < k; i--){
            for(int num : bucket[i]){
                result[index++] = num;
                if(index == k){
                    return result;
                }
            }
        }
        return result;
    }
}
