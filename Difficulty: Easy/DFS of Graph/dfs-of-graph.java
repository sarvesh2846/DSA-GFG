import java.util.*;

 class Solution {
     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

         int V = adj.size();
         ArrayList<Integer> ans = new ArrayList<>();
         boolean[] vis = new boolean[V];

         Stack<Integer> s = new Stack<>();

         s.push(0);

         while (!s.isEmpty()) {

             int curr = s.pop();

             if (!vis[curr]) {

                 ans.add(curr);
                 vis[curr] = true;

                 // Push neighbors in reverse order
                 for (int i = adj.get(curr).size() - 1; i >= 0; i--) {
                     int neighbor = adj.get(curr).get(i);

                     if (!vis[neighbor]) {
                         s.push(neighbor);
                     }
                 }
             }
         }

         return ans;
     }
 }