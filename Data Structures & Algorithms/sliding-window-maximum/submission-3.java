class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;
        int r = 0;

        while(r < nums.length){
            if (r >= k) {
                //need to schrink left
                result.add(deque.peekFirst());
                if(deque.peekFirst() != null && deque.peekFirst() == nums[l]) {
                    deque.pollFirst();
                }
                l++;
            }
            while(deque.peekLast() != null && deque.peekLast() < nums[r]) {
                deque.removeLast();
            }
            deque.add(nums[r]);
            r++;
        }
        result.add(deque.pollFirst());
        return result.stream().mapToInt(i -> i).toArray();
    }
}
