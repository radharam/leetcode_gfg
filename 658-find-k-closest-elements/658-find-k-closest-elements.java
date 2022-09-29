class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->((o1[0]!=o2[0])?(o2[0]-o1[0]):(o2[1]-o1[1]))); 
		// created a max PQ  by taking care of these two conditions ( |a - x| < |b - x|, 
        //or |a - x| == |b - x| and a < b
        
        for(int num:arr){
            pq.add(new int[]{Math.abs(num-x),num});
            if(pq.size()>k) pq.poll(); // whenever we exceed more then k element in out PQ this means we don't need to store any greater element more further since we already have optimal ans in our PQ as it's a max PQ 
        }
        
        while(k-->0){
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
    
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int idx = findIndexOfX(arr, x);
        
        if(arr.length == k) return new ArrayList(Arrays.asList(arr));
        
        int left = findIndexOfX(arr, x) - 1, right = left + 1;
        
        
        
        return new ArrayList<Integer>();
    }
    
    public int findIndexOfX(int[] arr, int x) {
        int l = 0, r = arr.length-1;
        
        while(l < r) {
            int m = l + ((r - l) >> 1);
            if(arr[m] >= x) r = m;
            else l = m+1;
        }
        
        return l;
    }
}