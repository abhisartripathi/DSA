/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Intersection of Two Arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        if(nums1.length<=nums2.length){
            addIntersection(num1,num2,map,intersect);
        }
        if(nums1.length>nums2.length){
            addIntersection(num2,num1,map,intersect);
        }
        int[] r = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++){
            r[i] = intersect.get(i); 
        }
        return r;
    }
    public void addIntersection(int[] nums1, int[] nums2, HashMap map, ArrayList<Integer> intersect) {
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],true);
        }
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])){
                intersect.add(nums2[i]);
                map.put(nums2[i],false);
            }
        }
    }
}

// Intersection of Two Arrays II

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        if(nums1.length<=nums2.length){
            addIntersection(nums1, nums2, map, intersect);
        }
        if(nums1.length>nums2.length){
            addIntersection(nums2, nums1, map, intersect);
        }
        int[] r = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++){
            r[i] = intersect.get(i); 
        }
        return r;
    }
    public void addIntersection(int[] nums1, int[] nums2, HashMap map, ArrayList<Integer> intersect) {
            for(int i=0; i<nums1.length; i++){
                if(map.containsKey(nums1[i])){
                    map.put(nums1[i],map.get(nums1[i])+1);
                }else {
                    map.put(nums1[i],1);
                }
            }
            for(int i=0; i<nums2.length; i++){
                if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                    intersect.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
            }
    }
}

//First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int countNeg = 0, min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                countNeg++;
            }
            if(nums[i]>=0 ){
                if(min>nums[i])
                    min = nums[i];
                map.put(nums[i], 1);
            }
        }
        // System.out.println(map);
        if(min>1){
            return 1;
        }
        for(int i=min+1;i<(min+nums.length-countNeg);i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        // System.out.println("min"+min+"dd"+(min+nums.length-countNeg));
        return min+nums.length-countNeg;
//         int i=0, j=nums.length-1;
        
//         while(i<j){
//             if(nums[i]>0 && nums[j]>0){
//                 i++;
//             }
//             if(nums[i]>0 && nums[j]<0){
//                 j--;
//             }
//             if(nums[i]<0 && nums[j]<0){
//                 j--;
//             }
//             if(nums[i]<0 && nums[j]>0){
//                 int temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//                 i++;
//                 j--;
//                 countNeg++;
//             }
//         }
        
//         for(i=0;i<nums.length-countNeg;i++){
//             if(nums[i] < (nums.length-countNeg)){
//                 nums[nums[i]] = -nums[nums[i]];
//             }
//         }
//         for(i=0;i<nums.length-countNeg;i++){
//             if(nums[i]>0){
//                 return i;
//             }
//         }
//         return 1;
    }
}

