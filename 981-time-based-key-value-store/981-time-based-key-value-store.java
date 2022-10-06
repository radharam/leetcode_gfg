
/*
    https://leetcode.com/problems/time-based-key-value-store/discuss/2668411/Three-Solutions-%3A-HashMap-or-TreeMap-or-Binary-Search

*/

class TimeMap {
    
    TreeMap <String, TreeMap<Integer,String>> map;
    public TimeMap() {
         map = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }
        
        Integer floor = map.get(key).floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        
        return map.get(key).get(floor);
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */