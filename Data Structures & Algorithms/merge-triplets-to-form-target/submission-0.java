class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean findX = false, findY = false, findZ = false;
        for(int[] triplet : triplets) {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                findX = triplet[0] == target[0] ? true : findX;
                findY = triplet[1] == target[1] ? true : findY;
                findZ = triplet[2] == target[2] ? true : findZ;
            }
        }
        return findX && findY && findZ;
    }
}
