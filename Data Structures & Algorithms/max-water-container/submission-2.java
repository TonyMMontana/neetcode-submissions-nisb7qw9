class Solution {
    public int maxArea(int[] heights) {
        int water = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r) {
            int cur = Math.min(heights[l], heights[r]) * (r - l);
            water = Math.max(water, cur);
            if(heights[l] >= heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return water;
    }
}
