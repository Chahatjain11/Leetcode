class MinStack {
    Stack <Long>st=new Stack<>();
    long min;


    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            min=value;
            st.push((long)value);
        }else if(value>=min){
            st.push((long)value);
        }else {
            long encoded=2L*value-min;
            st.push(encoded);
            min=value;
        }
     }
    
    public void pop() {
       if(st.isEmpty()){
        return;
       }long x=st.pop();
       if(x<min){
        min=2L*min-x;
       }
        
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }long x=st.peek();
        if(x<min){
            return(int)min;
        }return(int)x;
        
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }return(int)min;
        
    }
}