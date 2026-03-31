class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int trap = 0;
        
        while(l < r) {
            if(height[l] < height[r] || height[l] == height[r]) {
                if(height[l] > height[l + 1]){
                    while (height[l] > height[l + 1]) {
                        trap += height[l] - height[l + 1];
                        height[l + 1] = height[l];
                        l++; 
                    }
                } else {
                    l++;
                }
            } else if(height[r] < height[l]){
                if(height[r] > height[r - 1]){
                    while(height[r] > height[r - 1]) {
                        trap += height[r] - height[r - 1];
                        height[r-1] = height[r];
                        r--;
                    }
                } else{
                    r--;
                }
            }
        }
        return trap;
    }
}
