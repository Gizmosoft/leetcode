class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // BINARY SEARCH O(n.logm)
        int left = 1, right = 1;
        // get max of the pile
        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right) {
            int mid = left + (right-left)/2;
            int hourSpent = 0;

            for(int pile : piles) {
                hourSpent += Math.ceil((double) pile/mid);
            }

            if(hourSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;

        // BRUTE FORCE: O(n*m)
        // int speed = 1;

        // while (true) {
        //     int hourSpent = 0;

        //     for(int pile : piles) {
        //         hourSpent += Math.ceil((double) pile/speed);
        //         if(hourSpent > h) {
        //             break;
        //         }
        //     }

        //     if(hourSpent <= h) {
        //         return speed;
        //     } else {
        //         speed += 1;
        //     }
        // }
    }
}