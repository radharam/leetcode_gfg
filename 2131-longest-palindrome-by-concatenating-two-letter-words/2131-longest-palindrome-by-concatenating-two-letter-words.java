
// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/discuss/1675343/Python3-Java-C%2B%2B-Counting-Mirror-Words-O(n)

class Solution {
    //Solution 1: With HashMap
    public int longestPalindromeWithHashMap(String[] words) {
        HashMap<String, Integer> m = new HashMap();
        int unpaired = 0, ans = 0;
        for (String w: words) {
            if (!m.containsKey(w)) m.put(w, 0);
            if (w.charAt(0) == w.charAt(1)) {
                if (m.get(w) > 0) {
                    unpaired--;
                    m.put(w, m.get(w) - 1);
                    ans += 4;
                }
                else {
                    m.put(w, m.get(w) + 1);
                    unpaired++;
                }
            }
            else {
                String rev = Character.toString(w.charAt(1)) + 
                    Character.toString(w.charAt(0));
                if (m.containsKey(rev) && m.get(rev) > 0) {
                    ans += 4;
                    m.put(rev, m.get(rev) - 1);
                }
                else m.put(w, m.get(w) + 1);
            }

        }
        if (unpaired > 0) ans += 2;
        return ans;
    }
    
    //Solution 2: Without HashMap
    public int longestPalindrome(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;
        for (String w: words) {
            int a = w.charAt(0) - 'a', b = w.charAt(1) - 'a';
            if (counter[b][a] > 0) {
                ans += 4; 
                counter[b][a]--; 
            }
            else counter[a][b]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i][i] > 0) {
                ans += 2;
                break;
            }
        }
        return ans;
    }
}