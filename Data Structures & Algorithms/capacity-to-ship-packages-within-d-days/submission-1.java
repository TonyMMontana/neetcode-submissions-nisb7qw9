class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for(int i : weights) {
            l = Math.max(l, i);
            r += i;
        }

        while(l <= r) {
            int mid = l + (r - l) / 2; //ship capacity
            int time = 1;
            long load = 0;
            for(int weight : weights) {
                if(load + weight <= mid) {
                    load += weight;
                } else {
                    time++;
                    load = weight;
                }
            }

            if(time > days) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
         return l;
    }
}