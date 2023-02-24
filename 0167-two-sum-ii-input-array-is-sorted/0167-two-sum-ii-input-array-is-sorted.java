class Solution {
    public int[] twoSum(int[] numbers, int target) {
int[] rs=new int[2];
       for(int i=0;i<numbers.length;i++){
           for(int j=0;j<numbers.length&&j!=i;j++){
               int result=numbers[i]+numbers[j];
           if(result==target){
               rs[0]=j+1;
               rs[1]=i+1;
               return rs;
           }
       }
       }
       return null;
    }
}