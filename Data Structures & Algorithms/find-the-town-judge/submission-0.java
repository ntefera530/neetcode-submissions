class Solution {
    public int findJudge(int n, int[][] trust) {
        // trust[i][j] == i trusts j
        //int n = trust.length;

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for(int[] t : trust){
            int a = t[0];
            int b = t[1];

            indegree[b] += 1;
            outdegree[a] += 1;            
        }

        for(int i = 1; i < n + 1; i++){
            if(indegree[i] == n - 1 && outdegree[i] == 0){
                return i;
            }
        }

        return -1;
    }
}