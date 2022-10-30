class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        int n = s.length(), m=p.length();
        int[][] hash = new int[2][26]; // p -> 0  s -> 1
        if(m > n) return anagrams;
        for(int i=0; i<m; i++){
            int c1 = p.charAt(i) - 'a';
            int c2 = s.charAt(i) - 'a';
            hash[0][c1] += 1;
            hash[1][c2] += 1;            
        }
        int match = 0;
        for(int i=0; i<26; i++){
            if(hash[0][i] == hash[1][i]) match += 1;
        }
        if(match == 26) anagrams.add(0);
        for(int i=m; i<n; i++){
            int cs = s.charAt(i) - 'a';
            hash[1][cs] += 1;
            if(hash[1][cs] == hash[0][cs]) match += 1;
            if(hash[1][cs]-1 == hash[0][cs]) match -= 1;
            
            int ce = s.charAt(i-m) - 'a';
            hash[1][ce] -= 1;
            if(hash[1][ce] == hash[0][ce]) match += 1;
            if(hash[1][ce]+1 == hash[0][ce]) match -= 1;
            
            if(match == 26) anagrams.add(i-m+1);
        }
        return anagrams;
    }
}