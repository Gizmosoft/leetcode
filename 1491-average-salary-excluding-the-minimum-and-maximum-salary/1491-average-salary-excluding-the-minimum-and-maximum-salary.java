class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        Arrays.sort(salary);
        int elements = 0;
        double avg = 0;
        for(int i=1; i<n-1; i++){
            avg += salary[i];
            elements++;
        }
        avg = avg/elements;
        return avg;
        
    }
}