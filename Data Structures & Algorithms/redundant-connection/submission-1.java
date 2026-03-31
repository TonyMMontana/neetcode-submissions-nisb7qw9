class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for(int i =0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(parents, rank, edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        
        return new int[0];
    }

    private boolean union(int[] parents, int[] rank, int first, int second) {
        int p1 = find(parents, first);
        int p2 = find(parents, second);

        if(p1 == p2) {
            return false;
        }

        if(rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    private int find(int[] parents, int n) {
        int p = parents[n];
        while(p!= parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }
}
