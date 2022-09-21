
/*
        TC -> O(n)
        SC -> O(n), where n=length of queries array 
        
        Approach:
        We have to update items of nums array according to the queries and then count the sum of even numbers in the nums again.
        As we can see that, we are updating the nums' items one at a time and the update is making effect on the sum of even values what we can do is, first calculate the sum of even values of nums array(say, eSum) and then make update in the eSum when applying every query, and then store the updated value in a result array.
        
        Ex: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
        now, eSum = 6
        
        perform every query on eSum and make changes in nums and res array
        
        for query [1,0] -> val=1, idx=0
                           (element at idx)ele=1
                           as 1 is odd, it is sure that this is not included in eSum, so eSum remains unchanged
                           now what will be the changed value at index idx in nums, i.e, nums[idx] = nums[idx]+val
                           so, nums[idx] -> nums[0] = 2
                           as nums[idx](2) is even it will be included in the eSum, so eSum -> eSum+2=8
                           now change the 0th item of result array to 8
                           updated value, nums -> [2,2,3,4], eSum -> 8, res -> [8]
                           
        for query [-3,1] -> val=-3, idx=1
                            ele=2
                            2 is even, so it is included in eSum, hence update it(reduce eSum by ele, as eSum will change by the new value of nums[idx] if it is even)
                            eSum -> 6
                            nums[idx] = 2 + (-3) = -1(odd)
                            so it will not be included in eSum
                            updated values, nums -> [2,-1,3,4], eSum -> 6, res -> [8,6]
                            

    Now in the same way explained above, generate all the values of result array and return it
*/
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
	
		// get sum of even values of nums
        int eSum = 0;
        for(int e : nums) if((e&1)==0) eSum += e;
        
        int i=0;
        int[] res = new int[nums.length];
        
        for(int[] e : queries){
            
            // Value and Index to apply query
            int val = e[0], idx = e[1];
            int ele = nums[idx];
            
            // Reduce eSum if ele is included in eSum
            if((ele&1)==0) eSum -= ele;
            
            // Increase eSum if new nums[idx] is making an even value
            int sum = ele+val;
            if((sum&1)==0) eSum += sum;
            
            // now update the arrays
            nums[idx] = sum;
            res[i++] = eSum;
        }
        
        return res;
    }
}


