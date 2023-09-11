class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        
        if(flowerbed.length == 0)
            return false;
        
        if(flowerbed.length == 1){
            if(flowerbed[i] == 0){
                return true;
            }
            else{
                if(n == 0)
                    return true;
                else
                    return false;
            }
        }
        
        while(i < flowerbed.length && n != 0){
            if(i != 0 && i != flowerbed.length-1){
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else if(i == flowerbed.length-1){
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else{
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            i++;
        }
        
        if(n == 0){
            return true;
        }
        else
            return false;        
    }
}