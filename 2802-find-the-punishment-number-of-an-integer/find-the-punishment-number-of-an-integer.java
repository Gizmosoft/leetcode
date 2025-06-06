class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i=1; i<=n; i++) {
            if(partition(0, 0, i, String.valueOf(i*i)))
                res += i*i;
        }
        return res;
    }

    public boolean partition(int left, int sum, int target, String str) {
        if(left == str.length()) return sum == target;

        for(int right=left; right<str.length(); right++) {
            if(partition(right+1, sum + Integer.parseInt(str.substring(left, right+1)), target, str)) return true;
        }
        return false;
    }
}