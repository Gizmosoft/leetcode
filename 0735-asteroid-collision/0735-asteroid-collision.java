class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(Integer i : asteroids) {
            while(!stack.isEmpty() && (i<0) && (stack.peek() > 0)) {
                int diff = i + stack.peek();
                
                if(diff < 0) {
                    stack.pop();
                } else if(diff > 0) {
                    i = 0;
                } else {
                    i = 0;
                    stack.pop();
                }
            }
            
            if(i != 0) {
                stack.push(i);
            }
        }
        
        int[] result = new int[stack.size()];  
        int n = stack.size();
        for(int j=0; j<n; j++) {
            result[n - j - 1] = stack.pop();
        }
        
        return result;
        
    }
}