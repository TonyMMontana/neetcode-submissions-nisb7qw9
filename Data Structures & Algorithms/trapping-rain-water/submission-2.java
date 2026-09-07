class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        while(l < r) {
            if(height[l] <= height[r]) { 
                if(maxL > height[l]) {
                    sum += maxL - height[l];
                } else {
                    maxL = height[l];
                }
                l++;
            } else {
                if(maxR > height[r]) {
                    sum+=  maxR - height[r];
                } else {
                    maxR = height[r];
                } 
                r--;
            }
        }
        return sum;
    }
}
