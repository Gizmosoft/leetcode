class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNums = new HashSet<>();
        while(n != 1 && !seenNums.contains(n)) {
            seenNums.add(n);
            n = getSquaredSum(n);
        }
        return n==1;
    }

    private int getSquaredSum(int n) {
        int squared = 0;

        while(n > 0) {
            int digit = n%10;
            squared += Math.pow(digit, 2);
            n = n/10;
        }
        return squared;
    }
}