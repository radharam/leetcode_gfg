class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        Set<Integer> wordLength = new TreeSet<>();
        
        int len = words.length;
        
        for(int i = 0; i < len; i++) {
            wordMap.put(words[i], i);
            wordLength.add(words[i].length());
        }
        
        List<List<Integer>> palindromicPairs = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            int wlen = words[i].length();
            
            if(wlen ==1){
                if(wordMap.containsKey("")){
                    palindromicPairs.add(Arrays.asList(i, wordMap.get("")));
                    palindromicPairs.add(Arrays.asList(wordMap.get(""), i));
                }
                continue;
            }
            
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            
            if(wordMap.containsKey(reversedWord) && wordMap.get(reversedWord) != i) {
                palindromicPairs.add(Arrays.asList(wordMap.get(words[i]), wordMap.get(reversedWord)));
            }
            
            for(Integer k: wordLength){
                if(k == wlen) break;
                
                if(isPalindrome(reversedWord, 0, wlen-1-k)){
                    String s1 = reversedWord.substring(wlen-k);
                    if(wordMap.containsKey(s1))
                        palindromicPairs.add(Arrays.asList(i,wordMap.get(s1)));
                }
                
                if(isPalindrome(reversedWord, k, wlen-1)){
                    String s2 = reversedWord.substring(0, k);
                    if(wordMap.containsKey(s2))
                        palindromicPairs.add(Arrays.asList(wordMap.get(s2),i));
                }
            }
        }
        
        return palindromicPairs;
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        while(l < r) 
            if(s.charAt(l++)!=s.charAt(r--)) return false;     
        
        return true;
    }
    
    
}