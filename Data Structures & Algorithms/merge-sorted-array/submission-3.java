class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int l1 = 0;
        int l2 = 0;

        for(int i = 0; i < res.length; i++) {
            if(l2 >= n || (l1 < m && nums1[l1] < nums2[l2])) {
                res[i] = nums1[l1++];
            } else {
                    res[i] = nums2[l2++];
                }
            }
        
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = res[i];
        }
    }
}