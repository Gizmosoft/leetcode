class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
//         Runtime 0ms
        int zeros = 0, ones = 0;
        for(int s : students){
            if(s == 0)
                zeros++;
            else
                ones++;
        }
        
        for(int f : sandwiches){
            if(f == 0){
                if(zeros == 0){
                    return ones;
                }
                zeros--;
            }
            else{
                if(ones == 0){
                    return zeros;
                }
                ones--;
            }
        }
        
        return 0;
        
//         Runtime 2ms        
//         Stack<Integer> sandwich = new Stack<>();
//         Queue<Integer> student = new LinkedList<>();
        
//         int n = students.length;
        
//         for(int i=0; i<n; i++){
//             student.offer(students[i]);
//             sandwich.push(sandwiches[n-i-1]);
//         }
        
//         while(student.size() != 0){
//             if(student.peek() == sandwich.peek()){
//                 sandwich.pop();
//                 student.poll();
//             }
//             else{
//                 if(student.contains(sandwich.peek())){
//                     student.offer(student.poll());
//                 }
//                 else{
//                     return student.size();
//                 }
//             }
//         }
        
//         return student.size();
        
    }
}