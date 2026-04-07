class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = a + b;
            int tmp = a;
            a = b + a;
            b = tmp;
        }
        return res;
    }
}
