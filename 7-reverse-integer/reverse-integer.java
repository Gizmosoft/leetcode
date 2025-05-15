class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String num = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(num);
        sb.reverse();

        try {
            int reversed = Integer.parseInt(sb.toString());
            return isNegative ? -reversed : reversed;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}