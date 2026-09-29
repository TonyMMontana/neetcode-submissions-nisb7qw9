class Solution {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int l = 0;
        int r = x / 2;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            long cur = (long) mid * mid;
            if(cur < x) {
                l = mid + 1;
            } else if(cur > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return r;
    }
}