class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int s_len = s.length(), p_len = p.length(), match = 0;
        List<Integer> anagrams = new ArrayList<>();
        if(p_len > s_len) return anagrams;
        
        final int CHAR_SIZE = 26;
        int[][] perm = new int[2][CHAR_SIZE]; // s - 0, p - 1
        
        for(int i = 0; i < p_len; i++) {
            perm[0][s.charAt(i) - 'a']++;
            perm[1][p.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < CHAR_SIZE; i++) {
            if(perm[0][i] == perm[1][i]) match++;
        }
        
        if(match == CHAR_SIZE) anagrams.add(0);
        for(int i = p_len; i < s_len; i++) { 
            
            int l = s.charAt(i - p_len) - 'a', r = s.charAt(i)-'a';
            
            perm[0][l]--;
            if(perm[0][l] == perm[1][l]) match++;
            if(perm[0][l]+1 == perm[1][l]) match--;
            
            perm[0][r]++;
            if(perm[0][r] == perm[1][r]) match++;
            if(perm[0][r]-1 == perm[1][r]) match--;
            if(match == CHAR_SIZE) anagrams.add(i-p_len+1);
        }
        
        return anagrams;
    }
}