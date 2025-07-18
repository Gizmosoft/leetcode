class Solution {
    public boolean isPowerOfTwo(int n) {
        // return checkPower(n, 0);
        if(n == 0 || n < 0) return false;

        while(n % 2 == 0) {
            n /= 2;
        }

        return n==1;
    }

    // private boolean checkPower(int n, int x) {
    //     if(Math.pow(2, x) == n) return true;
    //     if(Math.pow(2, x) > Math.abs(n)) return false;

    //     boolean result = checkPower(n, x+1);
    //     return result;
    // }
}