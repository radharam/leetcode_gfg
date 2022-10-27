import java.awt.Point;

class Solution 
{
    public int largestOverlap(int[][] img1, int[][] img2) 
    {
        int n = img1.length;
        
        // [1] first, we list coordinates (x,y) of 1-points in each image
        
        var idx1 = new ArrayList<Point>();
        for (int i = 0; i < n*n; i++)
            if (img1[i/n][i%n] == 1) idx1.add(new Point(i/n, i%n));

        var idx2 = new ArrayList<Point>();
            for (int j = 0; j < n*n; j++)
                if (img2[j/n][j%n] == 1) idx2.add(new Point(j/n, j%n));
    
        // [2] second, we obtain translation vectors needed to overlap
        //    each 1-point of img1 with each 1-point of img2, and count
        //    frequencies of these vectors;

        var trVecs = new HashMap<Point,Integer>();
        for (var p1 : idx1)
            for (var p2 : idx2)
            {
                var vec = new Point(p1.x-p2.x, p1.y-p2.y);
                trVecs.put(vec, trVecs.getOrDefault(vec, 0) + 1);
            }
    
        // [3] translation vector that has been encountered most of the time is
        //    the one that produces an overlap of the maximal number of points

        if (trVecs.values().isEmpty()) 
            return 0; 
        else 
            return Collections.max(trVecs.values());
    }
}