class MinStack {
    Stack <Pair<Integer,Integer>>st=new Stack<>();


    public MinStack() {
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair<>(value,value));
        }else{
            int currentMin=st.peek().getValue();
            int newMin=Math.min(currentMin,value);//min between new value and prev min
            st.push(new Pair<>(value,newMin));//store actual value,min got so far
        }
        
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        return st.peek().getKey();
        
    }
    
    public int getMin() {
        return st.peek().getValue();
        
    }
}
class Pair<K,V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}