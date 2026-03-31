class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();


        ///count frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //create list
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[] {entry.getValue(), entry.getKey()});
        }
        //sort list
        list.sort((a,b) -> b[0] - a[0]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }

        return res;
    }
}
