class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        int[][][] dists = new int[m][n][k+1];
        for (int[][] dist : dists) 
            for (int[] d : dist)
                Arrays.fill(d, Integer.MAX_VALUE);
        
        Arrays.fill(dists[0][0], 0);
        
        // min-heap storing {i, j, # obstacles eliminated, dist}, sorted by distance to (0,0)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[3] - b[3]);
        heap.offer(new int[]{0, 0, 0, 0});
        
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (curr[0] == m-1 && curr[1] == n-1) continue;
            
            for (int[] dir : DIRECTIONS) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                
                // 1). continue if out of bound
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                
                // 2). continue if out of elimation
                int newK = curr[2] + grid[newX][newY];
                if (newK > k) continue;
                
                // 3). continue if we have more optimal result
                int newDist = curr[3] + 1;
                if (dists[newX][newY][newK] <= newDist) continue;
                
                dists[newX][newY][newK] = newDist;
                heap.offer(new int[]{newX, newY, newK, newDist});
            }
        }
        
        int res = dists[m-1][n-1][0];
        for (int i = 1; i <= k; i++) res = Math.min(res, dists[m-1][n-1][i]);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}