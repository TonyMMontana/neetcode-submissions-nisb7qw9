class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }

        int l = 2;
        int r = x  / 2;

        while(l <= r) {
            int mid = l + (r - l)  / 2;
            long pow = (long) mid * mid;

            if(pow < x) {
                l = mid + 1;
            } else if(pow > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return r;
    }
}