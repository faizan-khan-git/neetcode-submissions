class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        // add all course with 0 prereq to the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        // process independent courses level by level
        while(!q.isEmpty()){
            int curr = q.poll();
            order[index++] = curr;

            for(int neighbor : adj.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        if(index == numCourses){
            return order;
        }

        return new int[0];
    }
}
