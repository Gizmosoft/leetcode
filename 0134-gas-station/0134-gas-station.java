class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int current = 0;
        int startStation = 0;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];

            // If surplus is negative, you can't reach station i+1 from the current starting point
            if (current < 0) {
                // Try the next station as the starting point
                startStation = i+1;
                current = 0; // Reset the current surplus
            }
        }

        // Check if the total amount of gas is less than the total travel cost
        return total >= 0 ? startStation : -1;
    }
}