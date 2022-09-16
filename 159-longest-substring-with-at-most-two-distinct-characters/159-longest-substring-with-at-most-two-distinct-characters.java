class Solution {  

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int distinct = 0;
        int[] counts = new int['z' - 'A' + 1];
        int l = 0, r = 0;
        while (r < s.length()) {
            int ci = s.charAt(r++) - 'A';
            if (++counts[ci] == 1) {
                distinct++;
            }
            while (distinct > 2) {
                int lci = s.charAt(l++) - 'A';
                if (--counts[lci] == 0) {
                    distinct--;
                }
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
    
}