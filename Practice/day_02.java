/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Maximum Subarray (Kadanes algo).

class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE, max_till_now = 0;
        for(int i=0; i<nums.length; i++){
            max_till_now += nums[i];
            if(max_so_far<max_till_now){
                max_so_far = max_till_now;
            }
            if(max_till_now<0){ max_till_now = 0;}
        }
        return max_so_far;
    }
}

// Rotate array.

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==k || nums.length==0 || nums.length==1){return;}
        if(nums.length<k){k%=nums.length;}
        int pivot = nums.length-k-1;
        rotateRange(nums,0,pivot);
        rotateRange(nums,pivot+1,nums.length-1);
        rotateRange(nums,0,nums.length-1);
    }
    public void rotateRange(int[] nums, int start, int end) {
        int mid;
        if((end-start)%2==1){
            mid = start+1 + (end-start)/2;
        }else {
            mid = start + (end-start)/2;
        }
        
        for(int i=start;i<mid;i++){
            int temp = nums[end-i+start];
            nums[end-i+start] = nums[i];
            nums[i] = temp;
        }
    }
}


// Move zeroes to end 

class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0, end = 1;
        while((end<nums.length && start<nums.length)){
            if(nums[start] == 0 && nums[end] == 0){
                end++;
            }
            else if(nums[start] != 0 && nums[end] != 0){
                start++;
                end++;
            }
            else if(nums[start] == 0 && nums[end] != 0){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end++;
            }
            else if(nums[start] != 0 && nums[end] == 0){
                start++;
                end++;
            }
        }
    }
}

// Container with most water

class Solution {
    public int maxArea(int[] height) {
        int start=0, end = height.length-1, area = Integer.MIN_VALUE;
        for(int i =0;i<height.length;i++){
            int minHeight = Math.min(height[start], height[end]);
            area = Math.max(area, minHeight*(end-start));
            if(height[start]<= height[end]){
                start++;
            }else {
                end--;
            }
        }
        return area;
    }
}

// Rain water collection problem

class Solution {
    public int trap(int[] height) {
        int vol = 0;
        if(height.length==0){return 0;}
        int lHeight = height[0];
        
        for(int i=1;i<height.length-1;i++){
            int rHeight = height[getRightMaxHeight(height, i+1)];
            if(lHeight<height[i]){
                lHeight = height[i];
            }
            if(lHeight > height[i] && rHeight > height[i]){
                vol+=Math.abs((Math.min(lHeight, rHeight)-height[i]));
            }
        }
        return vol;
    }
    public int getRightMaxHeight(int[] height,int start) {
        int rHeight = start;
        for(int i=start; i<height.length; i++){
            if(height[rHeight] < height[i] ){
                rHeight = i;
            }
        }
        return rHeight;
    }
}
