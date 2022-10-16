class Solution {
    public int minDifficulty(int[] jD, int d) {
        
        int n = jD.length;
        int [][]dp = new int[d+1][n+1]; // dp
        
        for( int i=0; i<=d; i++ ) {
          /*  the limit for the elements is the amount of partitions left so if we have no partitions left then we can go all the way from the first element to the last but if we have one partition left , we have to leave one element by default to make sure that even if we take all elements for current subarray there is still an element left in order for that one partition to accomodate */
            int left = (d-i);
            for( int j=n; j>=left; j--) {
                
				// default answer
                int cans = (int)1e5;
                
				// base case 
                if( i==0 && j==n ) dp[i][j] = 0;
				// in cases when elements are less than partition
                else if( i==0 || j==n ) dp[i][j] = cans;
                else {
                    int max = -1;
					// loop to check the for the condition mentioned
                    for( int k=j+1; k<=n; k++ ) {
                        max = Math.max(jD[k-1],max);
                        cans = Math.min(cans,max+dp[i-1][k]);
                    }
                    
                    dp[i][j] = cans;
                }
            }
        }
        
        return (dp[d][0]==(int)1e5) ? -1 : dp[d][0];
    }
}