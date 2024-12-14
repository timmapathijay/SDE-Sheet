class Solution {
    // Function to detect cycle in a directed graph.
    public boolean checkCycle(int Node , ArrayList<ArrayList<Integer>> adj , 
    boolean[] visited , boolean[] dfsVis)
    {
        visited[Node] = true;
        dfsVis[Node] = true;
        for(Integer adjNode : adj.get(Node))
        {
            if(!visited[adjNode])
            {
                if(checkCycle(adjNode , adj , visited , dfsVis))
                return true;
            }
            else if(dfsVis[adjNode])
            return true;
        }
        dfsVis[Node] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[] = new boolean[V];
       boolean dfsVis[] = new boolean[V];
       for(int i = 0 ; i < V ; i++) // Disconnected Graph [Multiple-Components] 
       {
           if(!visited[i])
           {
               if(checkCycle(i , adj , visited , dfsVis))
               return true;
           }
       }
       return false;
    }
}
// TC : O(V + E)
// SC : N[Visited] + N[DFS Visited] + N[Recursive Stack Space] => O(3N)
