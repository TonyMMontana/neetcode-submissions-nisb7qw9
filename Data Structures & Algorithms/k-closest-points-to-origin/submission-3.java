class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, Point> map = new HashMap<>();
        PriorityQueue<Point> queue = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));

        for(int i = 0; i < points.length; i++) {
            double distance = Math.pow(0 - points[i][0], 2) + Math.pow(0 - points[i][1],2);
            Point point = new Point(distance, points[i]);
            queue.add(point);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!queue.isEmpty()) {
            res[i++] = queue.poll().coord;
        }
        return res;
    }

    private class Point {
        double dist;
        int[] coord;

        public Point(double dist, int[] coord) {
            this.dist = dist;
            this.coord = coord;
        }
    }
}
