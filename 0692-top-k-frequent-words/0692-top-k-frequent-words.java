class Pair{
    String word;
    int count;
    Pair(int count, String word) 
    { this.word = word; this.count = count; }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String, Integer>mp = new HashMap();
        for (String word : words) mp.put(word, mp.getOrDefault(word, 0) + 1);
        //=============================================================
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((Pair a, Pair b)->{
            if (a.count == b.count) return (b.word.compareTo(a.word));
            else return (a.count - b.count); 
        });
        //=================================================================
        for (String currWord : mp.keySet())
        {
            int currCount = mp.get(currWord);
            if (pq.size() < k) pq.add(new Pair(currCount, currWord));
            else
            {
                int mnCount = pq.peek().count;  //min Freq in priority queue
                String mnWord = pq.peek().word;  
                if (currCount > mnCount)
                {
                    pq.poll();
                    pq.add(new Pair(currCount, currWord));
                }
                else if (currCount == mnCount)
                {
                    boolean isCurrLexSmaller = (currWord.compareTo(mnWord) < 0)? true : false;
                    if (isCurrLexSmaller) 
                    {
                        pq.poll();
                        pq.add(new Pair(currCount, currWord));
                    }
                } 
            }
        }
        //=======================================================================
        List<String>ans = new ArrayList();
        while(!pq.isEmpty()) ans.add(pq.poll().word);
        Collections.reverse(ans);
        return ans;
        
    }
}