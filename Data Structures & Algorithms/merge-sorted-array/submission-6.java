class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;
        int first = m - 1;
        int second = n - 1;

        while(second >= 0) {
            if(first >= 0 && nums1[first] >= nums2[second]) {
                nums1[idx] = nums1[first];
                first--;
            } else {
                nums1[idx] = nums2[second];
                second--;
            }
            idx--;
        }
    }
}