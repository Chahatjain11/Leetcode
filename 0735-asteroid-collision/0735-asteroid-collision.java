class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){//asteroids going right,oush it in stack
                st.push(asteroids[i]);
            }else{//if its going left collision may happen
            //1. remove smaller right moving asteroids
            while(!st.isEmpty() && st.peek()>0 && st.peek() < Math.abs(asteroids[i])){
                st.pop();
            }//2. equal size asteroids destroy each other
            if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                st.pop();
            }//3.if stack is empty or top asteroids move left,current asetroids survive
            else if(st.isEmpty() || st.peek()<0){
                st.push(asteroids[i]);
            }
            // Otherwise, stack top is larger and moving right,
                // so the current left-moving asteroid is destroyed

            }
        }
        //convert stack into an array in the correct order
        int[] ans=new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i]=st.get(i);
        }
        return ans;

        
    }
}