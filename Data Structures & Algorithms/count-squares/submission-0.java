class CountSquares {
    private List<int[]> points;
    private Map<String, Integer> pointsCount;

    public CountSquares() {
        points = new ArrayList<>();
        pointsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String key = point[0] + "," + point[1];
        pointsCount.put(key, pointsCount.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];

        int totalSquares = 0;

        for(int[] p : points){
            int px = p[0];
            int py = p[1];

            if (Math.abs(qx - px) != Math.abs(qy - py) || qx == px || qy == py) {
                continue;
            }

            String corner1 = px + "," + qy;
            String corner2 = qx + "," + py;

            totalSquares += pointsCount.getOrDefault(corner1, 0) * pointsCount.getOrDefault(corner2, 0);
        }

        return totalSquares;
    }
}
