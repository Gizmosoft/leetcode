class Solution {
    public String intToRoman(int num) {
        String romanNum = "";
        
        int[] intData = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strData = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        for(int i=0; i<intData.length; i++){
            while(num >= intData[i]){
                romanNum += strData[i];
                num -= intData[i];
            }
        }
        
        return romanNum;        
    }
}