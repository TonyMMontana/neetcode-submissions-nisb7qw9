class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        int max = nums[0];

        while(r < nums.length){

            if(r - l >= k) {
                //add max
                //eveluate new max
                result.add(max);
                if(nums[l] == max) {
                    max = Integer.MIN_VALUE;
                    //update max
                    for(int i = l + 1; i <= r; i++) {
                        max = Math.max(max, nums[i]);
                    }
                }
                l++;
            }
            max = Math.max(max, nums[r]);
            r++;
        }
        result.add(max);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
