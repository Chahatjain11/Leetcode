class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            //remove big digit fro stk 
            //if curr digit is smaller and we can still remove digits
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }st.push(ch);
            }
            //if still k digits are left remove frome  end
            while(k>0 && !st.isEmpty()){
                st.pop();
                k--;
            }
            //if no digit is remain ans is 0
            if(st.isEmpty()){
                return "0";
            }
            //build string frm stk
            StringBuilder res= new StringBuilder();

            while(!st.isEmpty()){
                res.append(st.pop());
            }res.reverse();//stck gives digits in revers eorder so reverse
            //remve leading zeroes
            while(res.length()>0 && res.charAt(0)=='0'){
                res.deleteCharAt(0);
            }
            //if result contains only zeroes
            if(res.length()==0){
                return "0";
            }return res.toString();

        
    }
}