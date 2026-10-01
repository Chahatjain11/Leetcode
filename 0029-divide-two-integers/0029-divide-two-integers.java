class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor){
            return 1;
        }
        boolean sign =true;//check sign
        if(dividend>=0 && divisor<0){
            sign =false;//agr ek pos,ek neg hai ans neg hoga  
        }
        if(dividend<0 && divisor>=0){
            sign =false;
        }
        //32 bit int range
        long n=Math.abs((long) dividend);
        long d=Math.abs((long) divisor);

        long quotient=0;

        while(n>=d){
            int count=0;
            //jab tak n se chota h double krte rho 3,6,12,24
            while(n>=(d<<(count+1))){
                count++;
            }
            quotient+=(1L << count);
            n-=(d<<count);//dividend se wo amount subtract kro
        }
        if(quotient >Integer.MAX_VALUE && sign){
            return Integer.MAX_VALUE;
        }
        if(!sign){
            quotient=-quotient;
        }
        return (int)quotient;


        
    }
}