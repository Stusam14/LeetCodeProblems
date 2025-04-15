class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> hts = new Stack<>();
        Stack<Integer> pstns = new Stack<>();
        int len = heights.length;
        int maxValue = 0;
        for(int i = 0; i < len; i++ ){

            int start = i;
            while( !hts.isEmpty() && hts.peek() > heights[i]){
                int h = hts.pop();
                int pos = pstns.pop();
                int area = h*(i - pos);
                maxValue = Math.max(maxValue, area);
                start = pos;
            }

            hts.push(heights[i]);
            pstns.push(start);
        }

        while(!hts.isEmpty() && !pstns.isEmpty()){

            int h = hts.pop();
            int pos = pstns.pop();
            int area = h*(len - pos);
            maxValue = Math.max(maxValue, area);
        }

        return maxValue;
    }
}