class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while(l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            max = Math.max(max, minHeight * (r - l));

            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
