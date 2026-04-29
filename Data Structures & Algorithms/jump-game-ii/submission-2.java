class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        queue.add(new int[]{0, 1});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] + nums[cur[0]] >= nums.length - 1) return cur[1];

            for(int i = cur[0] + nums[cur[0]]; i > cur[0]; i--) {
                if(!visited[i]) {
                    queue.add(new int[] {i, cur[1] + 1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}
