class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = 0;

        for(int i : weights) {
            l = Math.max(l, i);
            r += i;
        }

        while(l <= r) {
            int mid = l + (r - l) / 2; // weight capacity of the ship
            int totalWeight = 0;
            int count = 1;

            for(int weight : weights) {
                if(totalWeight + weight <= mid) {
                    totalWeight += weight;
                } else {
                    count++;
                    totalWeight = weight;
                }
            }

            if(count > days) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}