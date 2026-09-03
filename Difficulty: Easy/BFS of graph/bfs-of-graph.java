import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];

        ArrayList<Integer> ans = new ArrayList<>();

        q.add(0);

        while(!q.isEmpty()){

            int curr = q.remove();

            if(!vis[curr]){

                ans.add(curr);
                vis[curr] = true;

                for(int i=0; i<adj.get(curr).size(); i++){
                    int neighbor = adj.get(curr).get(i);
                    q.add(neighbor);
                }
            }
        }
        return ans;
    }
}