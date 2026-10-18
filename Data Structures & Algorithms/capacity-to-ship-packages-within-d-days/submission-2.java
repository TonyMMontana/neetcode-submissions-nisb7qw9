class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for(int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while(l <= r) {
            int capacity = l + (r - l) / 2;
            int time = 1;
            long curWeight = 0;
            for(int w : weights) {
                if(curWeight + w > capacity) {
                    time++;
                    curWeight = 0;
                }
                curWeight += w;
            }

            if(time > days) {
                l = capacity + 1;
            } else {
                r = capacity - 1;
            }
        }

        return l;
    }
}