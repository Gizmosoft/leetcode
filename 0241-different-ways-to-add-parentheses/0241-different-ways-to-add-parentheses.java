class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> leftSubString = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightSubString = diffWaysToCompute(expression.substring(i+1));
            
                for(Integer l : leftSubString){
                    for(Integer r : rightSubString){
                        int x = 0;
                        switch(expression.charAt(i)){
                            case '+':
                                x = l+r;
                                break;
                            case '-':
                                x = l-r;
                                break;
                            case '*':
                                x = l*r;
                                break;
                        }
                        answer.add(x);
                    }
                }
            }
        }
        
        if(answer.size() == 0){
            answer.add(Integer.valueOf(expression));
        }
        
        return answer;
    }
}