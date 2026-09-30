class Solution {
    public int[] singleNumber(int[] nums) {
        //sabhi duplicate no ko sparte krnge
      int xor=0;
      for(int num:nums){
        xor=xor^num;
      }
      //ab dono uniqure no ko spearte krna h
      //rightmost bit find krnge
      //esa bit jaha dono no unique hoske
      int rightmost=(xor & (xor-1))^xor;

      int bucket1=0;
      int bucket2=0;

      //har no ko 2 bucket mie divide kro
      for(int num:nums){
        if((num & rightmost)!=0){
            bucket1=bucket1^num;
        }else{
            bucket2=bucket2^num;
        }
      }return new int[]{bucket1,bucket2};
    }
}

