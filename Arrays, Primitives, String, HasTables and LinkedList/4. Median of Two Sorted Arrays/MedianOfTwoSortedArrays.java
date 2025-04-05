class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] mergedArr  =  new int[nums1.length + nums2.length];
        int k =0;
        int i=0; 
        int j=0;

        while( i < nums1.length && j < nums2.length ){

            if(nums1[i] < nums2[j]){
                mergedArr[k++] = nums1[i++]; 
            }else{
                mergedArr[k++] = nums2[j++];
            }

        }

        while(i < nums1.length){
            mergedArr[k++] = nums1[i++];
        }
        while(j < nums2.length){
            mergedArr[k++] = nums2[j++];
        }

        if(mergedArr.length%2 == 0 ){
            return ((mergedArr[mergedArr.length/2 -1])+(mergedArr[mergedArr.length/2]))/2.0;
        }
        return mergedArr[mergedArr.length/2];
    }
}