class MyStack {
    Queue <Integer> q=new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.offer(x);
        int size=q.size();
        for(int i=0;i<size-1;i++){
          q.offer(q.poll());//front se hatakr piche kro
        }
    }
    
    public int pop() {
        q.peek();
        if(q.isEmpty()){
            return -1;
        }return q.poll();
        }
    
    public int top() {
        if(q.isEmpty()){
            return -1;
        }return q.peek();
        
    }
    
    public boolean empty() {
        return q.isEmpty();
        
    }
}
