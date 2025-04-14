class Solution {
    public int trap(int[] height) {
        
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        int maxSoFarLeft = Integer.MIN_VALUE;
        int maxSoFarRight = Integer.MIN_VALUE;
        int len = height.length; 
        for(int i=0; i< len; i++){
            maxSoFarLeft = Math.max(height[i],maxSoFarLeft);
            leftHeight[i] = maxSoFarLeft;

            maxSoFarRight = Math.max(height[len-1-i],maxSoFarRight);
            rightHeight[len-1-i] = maxSoFarRight;
        }

        int res = 0;
        for(int i=0; i< len; i++){
            int sum = Math.min(leftHeight[i],rightHeight[i]) - height[i];
            res += (sum < 0)? 0 : sum;
        }

        return res;
    }
}