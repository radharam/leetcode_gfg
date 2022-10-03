class Solution {
    public int lengthOfLongestSubstring(String s) {
    
        int len = s.length();
        if(len == 0) return 0;

        int maxlen = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for(int start = 0, end = 0; start < len; start++) {
            char ch = s.charAt(start);
            charFreq.put(ch, charFreq.getOrDefault(ch, 0)+1);
            
            while(end < len && charFreq.get(ch) > 1) {
                if(charFreq.get(s.charAt(end) )== 1) charFreq.remove(s.charAt(end));
                else charFreq.put(s.charAt(end), charFreq.get(s.charAt(end))-1);

                end++;
            }
            
            maxlen = Math.max(maxlen, start - end + 1);
        }
                   
    return maxlen;

    }
}