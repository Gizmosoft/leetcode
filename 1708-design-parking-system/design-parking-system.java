class ParkingSystem {
    // private int big;
    // private int medium;
    // private int small;

    private int[] spotsAvailable;
    public ParkingSystem(int big, int medium, int small) {
        // this.big = big;
        // this.medium = medium;
        // this.small = small;
        spotsAvailable = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if(spotsAvailable[carType] == 0) return false;

        --spotsAvailable[carType];
        return true;

        // switch (carType) {
        //     case 1:
        //         if(this.big >= 1) {
        //             this.big -= 1;
        //             return true;
        //         } else
        //             return false;
            
        //     case 2:
        //         if(this.medium >= 1) {
        //             this.medium -= 1;
        //             return true;
        //         } else
        //             return false;
            
        //     case 3:
        //     if (this.small >= 1) {
        //         this.small -= 1;
        //         return true;
        //     } else {
        //         return false;
        //     }

        //     default:
        //         return false; 
        // }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */