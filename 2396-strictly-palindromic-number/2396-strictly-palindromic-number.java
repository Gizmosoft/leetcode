class Solution {
    public boolean isStrictlyPalindromic(int n) {
        
        String num = Integer.toString(n);
        
        for(int i=2; i<=n; i++){
            String convertedNum = Integer.toString(Integer.parseInt(num, 10), i);
            if(!isPalindrome(convertedNum))
                return false;
        }
        
        return true;
        
    }
    
    public boolean isPalindrome(String num){
        int left = 0;
        int right = num.length()-1;
        
        while(left<=right){
            if(num.charAt(left) != num.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}