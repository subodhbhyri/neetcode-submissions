class Solution {
    int[] parents;
    int[] ranks;
    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        ranks = new int[n];
        int components = n;
        Arrays.fill(ranks, 0);
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            if(find(a) == find(b)){
                continue;
            }
            else{
                union(a, b);
                components--;
            }
        }
        return components;
    }

    public int find(int a){
        if(parents[a] == a){
            return a;
        }
        parents[a] = find(parents[a]);
        return parents[a];
    }

    public void union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(parA == parB){
            return;
        }
        if(ranks[parA] > ranks[parB]){
            parents[parB] = parA;
        }
        else if(ranks[parB] > ranks[parA]){
            parents[parA] = parB;
        }
        else{
            parents[parB] = parA;
            ranks[parA]++;
        }
    }
}


/*
    n = 5, edges = [[0,1],  
                    [1,2],
                    [3,4]]
*/