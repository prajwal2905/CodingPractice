class ProductOfArrayExceptSelf {
public int[] productExceptSelf(int[] nums) {
        
        int temp = 1;
        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i != 0){
                temp = nums[i-1];
                temp = temp * output[i-1];
            }
            output[i] = temp;
        }
        temp = 1;
        for(int i=nums.length-1; i>=0;i--){
            if(i != nums.length-1) {
                temp = nums[i+1] * temp; 
            }
            output[i] = output[i] * temp;
        }
        return output;
    }
}
