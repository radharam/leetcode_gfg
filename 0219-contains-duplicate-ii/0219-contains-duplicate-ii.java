class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Create a hashmap to store value of nums with their index.
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            // If nums[i] not present put it normally.
            if(map.get(nums[i]) == null)
                map.put(nums[i],i);
            else{
                //If already present get the value first
                Integer in = map.get(nums[i]);
                //Check out condition after getting the value
                //If satisfied return true here.
                if(Math.abs(in-i) <= k) return true;
                //If above statement return false it means we have 
                // larger value than k, we need to update the value till now.
                map.put(nums[i],i);
            }
        }
        return false;
    }
}