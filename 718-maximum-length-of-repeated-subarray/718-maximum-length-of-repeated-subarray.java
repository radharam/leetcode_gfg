class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] lcs = new int[len1+1][len2+1];
        int maxLen = 0;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                
                if(nums1[i-1] == nums2[j-1]) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                    maxLen = Math.max(maxLen, lcs[i][j]);
                }
                
                else lcs[i][j] = 0;   
            }
        }
        
        return maxLen;
    }
}