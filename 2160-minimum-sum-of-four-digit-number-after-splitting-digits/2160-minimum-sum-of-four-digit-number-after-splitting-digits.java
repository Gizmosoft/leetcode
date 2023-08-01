class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];  // create array to store digits
        int  n = num;
        int i=0;
        
        // adding all digits of num to digits[]
        while(n>0){
            digits[i] = n%10;
            i++;
            n = n/10;
        }
        
        Arrays.sort(digits);
        // the sorted array will have the lowest sum combo of 1st*10 and the 3rd element added to 2nd*10 and 4th element
        int x = digits[0]*10 + digits[2];
        int y = digits[1]*10 + digits[3];
        
        return x+y;
        
    }
}