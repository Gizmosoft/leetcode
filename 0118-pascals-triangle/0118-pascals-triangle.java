class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(1)));
        int gaps = 0;
        while(numRows > 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prevList = answer.get(gaps);
            for(int i=0; i<gaps; i++) {
                // add 2 elements at a time from answer.get(gaps) list
                list.add(prevList.get(i) + prevList.get(i+1));
            }
            list.add(1);
            answer.add(list);
            gaps++;
            numRows--;            
        }
        
        return answer;
        
    }
}