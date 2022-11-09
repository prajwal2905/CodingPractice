class ProductOfArrayExceptSelf {
//[1,2,3,4]
//Array can be positive, negative or zeros
        //Three ways to solve O(n2) - > Go over array calculate product of all elements except self and add to output
        // O(n) with space -> Have two arrays pre and post add post multiple of each element in post array and pre multiple of each element in second and finally multiply each element in both arrays
        // O(n) with temp variable -> have a temp variable assigned to 1 iterate once with calculating pre miltiples in output, next calculate post and multiply using the output array.
        
// Pre [1, 1, 2, 6]
//Post [24, 12, 4, 1]
//REsult [24, 12, 8, 6]
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
