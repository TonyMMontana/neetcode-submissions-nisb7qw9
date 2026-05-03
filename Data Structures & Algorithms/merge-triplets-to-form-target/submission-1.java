class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false, y = false, z = false;
        
        for(int[] triplet : triplets) {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                x = triplet[0] == target[0] ? true : x;
                y = triplet[1] == target[1] ? true : y;
                z = triplet[2] == target[2] ? true : z;
            }
        }
        return x && y && z;

    }
}
