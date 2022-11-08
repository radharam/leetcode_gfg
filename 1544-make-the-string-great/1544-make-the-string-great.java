class Solution {
    public String makeGood(String s) {
        if(s.length() == 1) return s;
        
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
          if(!stack.isEmpty() && (ch ^ 32) == stack.peek()) {
            stack.pop();
          }
          else {
            stack.push(ch);
          }
        }
        
        char res[] = new char[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        
        return new String(res);
    }
}