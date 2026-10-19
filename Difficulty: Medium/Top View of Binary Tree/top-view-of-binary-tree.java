/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
} */
// hd => Horizontal Distance
import java.util.*;

class Solution {
    static class Info{
        Node node;
        int hd;
        
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
   public ArrayList<Integer> topView(Node root) {
        
        int min = 0, max = 0;
        
        ArrayList<Integer> ansList = new ArrayList<>();
        
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        q.add(new Info(root, 0));
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node.data);
            }
            
            if(curr.node.left != null){
                q.add(new Info(curr.node.left , curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }
            
            if(curr.node.right != null){
                q.add(new Info(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }
        
        for(int i = min; i <= max; i++){
            ansList.add(map.get(i));
        }
        
        return ansList;
    }
}