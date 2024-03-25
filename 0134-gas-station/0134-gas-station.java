class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startStation = 0;
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i%n] - cost[i%n];
            currentSurplus += gas[i%n] - cost[i%n];

            // If surplus is negative, you can't reach station i+1 from the current starting point
            if (currentSurplus < 0) {
                // Try the next station as the starting point
                startStation = (i + 1)%n;
                currentSurplus = 0; // Reset the current surplus
            }
        }

        // Check if the total amount of gas is less than the total travel cost
        return totalSurplus >= 0 ? startStation : -1;
        
        
//         int n = gas.length;
        
//         for(int i=0; i<n; i++) {
//             int iters = n;
//             int tank = gas[i];
//             int index = i;
//             int next;
//             while(iters > 0) {
//                 next = (index+1)%n;
//                 tank = tank - cost[index] + gas[next];
//                 if(tank < cost[next]) {
//                     break;
//                 }                
//                 iters--;
//                 index = next;
//             }
            
//             if(iters == 0) {
//                 return i;
//             }
//         }
//         return -1;
    }
}