class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwich = new Stack<>();
        Queue<Integer> student = new LinkedList<>();
        
        int n = students.length;
        
        for(int i=0; i<n; i++){
            student.offer(students[i]);
            sandwich.push(sandwiches[n-i-1]);
        }
        
        while(student.size() != 0){
            if(student.peek() == sandwich.peek()){
                sandwich.pop();
                student.poll();
            }
            else{
                if(student.contains(sandwich.peek())){
                    student.offer(student.poll());
                }
                else{
                    return student.size();
                }
            }
        }
        
        return student.size();
        
    }
}