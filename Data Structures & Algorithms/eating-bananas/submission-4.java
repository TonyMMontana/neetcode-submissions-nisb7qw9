class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int i : piles) {
            r = Math.max(i, r);
        }

        while(l <= r) {
            int mid = l + (r - l) / 2;
            int time = 0;
            for(int pile : piles) {
                time += (pile + mid - 1) / mid;
            }
            if(time > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
