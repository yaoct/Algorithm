class LeetCode31 {
    public void nextPermutation(int[] nums) {
        //思路：从倒数第二位开始找,右边第一个大于改数的数交换,再逆序
        for(int i=nums.length-2;i>=0;i--){
          for(int j=nums.length-1;j>i;j--){
              if(nums[j]>nums[i]){
                  swap(nums,i,j);
                  rearrange(nums,i+1,nums.length-1);
                  return;
              }
          }
        }
        rearrange(nums,0,nums.length-1);
        return;
    }
    public void swap(int[] nums,int a,int b){
        int temp=0;
        temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void rearrange(int[] arr,int left,int right){
        int temp=0;
        for(int i=0;i+left<right-i;i++){//i+left左起下标
            swap(arr,i+left,right-i);
        }
    }
}