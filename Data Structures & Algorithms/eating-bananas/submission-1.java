class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int banana : piles) {
            max = Math.max(max, banana);
        }

        int l = 0;
        int r = max;
        int k = max;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            boolean valid = computeK(mid, piles, h);

            //here i need to count k and based on the comparing with h move pointers
            if (valid) {
                k = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }

    private boolean computeK(int value, int[] piles, int h) {
        long required = 0;
        for(int pile : piles) {
            required += Math.ceil((double) pile / value);
        }
        return required <= h;
    }
}
