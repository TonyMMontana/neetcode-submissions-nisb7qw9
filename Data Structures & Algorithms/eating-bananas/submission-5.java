class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int i : piles) {
            r = Math.max(r, i);
        }

        while(l <= r) {
            int speed = l + (r - l) / 2;
            int time = 0;
            for(int pile : piles) {
                time += (pile + speed - 1) / speed;
            }

            if(time > h) {
                l = speed + 1;
            } else {
                r = speed - 1;
            }
        }

        return l;
    }
}
