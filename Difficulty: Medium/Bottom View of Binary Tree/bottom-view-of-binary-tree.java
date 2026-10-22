/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
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
    public ArrayList<Integer> bottomView(Node root) {
        
        int min = 0, max = 0;

        ArrayList<Integer> ansList = new ArrayList<>();

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(new Info(root, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            
                map.put(curr.hd, curr.node.data);

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

