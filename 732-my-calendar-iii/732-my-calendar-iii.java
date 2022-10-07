class MyCalendarThree {
   
    private TreeMap<Integer, Integer> calmap;
    
    public MyCalendarThree() {
        calmap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        //starting events add one to it
        calmap.put(start,calmap.getOrDefault(start,0) + 1);
        // ending time subtract one to it , so that  it will let us end an event started before by subtracting active events for that time;
        calmap.put(end,calmap.getOrDefault(end,0) -1);
        
        int maxActiveBooking = 0,activeBookings = 0;
        // We have keys already in sorted order.
        for(int events : calmap.values()){
            activeBookings += events;
            maxActiveBooking = Math.max(maxActiveBooking, activeBookings);
        }
        return maxActiveBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */