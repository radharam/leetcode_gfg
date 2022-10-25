class Solution {
    public boolean arrayStringsAreEqualJava8(String[] word1, String[] word2) {
        String w1 = Stream.of(word1).collect(Collectors.joining()); 
        String w2 = Stream.of(word2).collect(Collectors.joining()); 
        
        return w1.equalsIgnoreCase(w2);
    }
    
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        return String.join("", word1).equals(String.join("", word2));
    }
    
}