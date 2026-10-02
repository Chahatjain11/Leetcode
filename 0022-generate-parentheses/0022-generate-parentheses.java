class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        generate(result,n,0,0,"");
        return result;
    }
    public void generate(List<String> result,int max,int open,int close, String unProcessed){
        if(unProcessed.length()==2*max){
            result.add(unProcessed);
            return;
        }
        if(open<max){
            generate(result,max,open+1,close,unProcessed+"(");
        }
        if(close<open){
            generate(result,max,open,close+1,unProcessed+")");
        }

        
    }
}