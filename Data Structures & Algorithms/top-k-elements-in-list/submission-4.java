class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)  + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[0]));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new int[] {entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i =0; i < k; i++) {
            result[i] = Objects.requireNonNull(heap.poll())[1];
        }

        return result;
    }
}
