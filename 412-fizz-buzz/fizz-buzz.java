class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        String[] arr = new String[n+1];
        recursive(n, arr);
        for(int i=1; i<=n; i++) {
            answer.add(arr[i]);
        }
        return answer;
    }

    private void recursive(int n, String[] arr) {
        if(n == 0) return;

        if(n%3 == 0 && n%5 == 0) arr[n] = "FizzBuzz";
        else if(n%3 == 0) arr[n] = "Fizz";
        else if(n%5 == 0) arr[n] = "Buzz";
        else arr[n] = String.valueOf(n);

        recursive(n-1, arr);
    }
}