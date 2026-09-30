class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int pile : piles) {
            r = Math.max(pile, r);
        }
        
        int hours = r;

        while(l <= r) {
            double mid = l + (r - l) / 2;
            int time = 0;
            for(int pile : piles) {
                time += Math.ceil((int) pile / mid);
            }
            if(time > h) {
                l = (int)mid + 1;
            } else if(time <= h) {
                r = (int)mid - 1;
            } 
        }

        return l;
    }
}
