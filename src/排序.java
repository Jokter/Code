public class 排序 {
    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        nums = order(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }

    private static int[] order(int[] nums){
        int len = nums.length;
        int i,j;
        for(i = 0;i<nums.length;i++){
            int x = nums[i];
            for(j=i-1;j>=0;j--){
                if(nums[j]>nums[i]){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = x;
        }
        return nums;
    }
}
