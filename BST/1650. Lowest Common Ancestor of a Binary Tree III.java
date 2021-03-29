

/*
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    public Node lowestCommonAncestor(Node p, Node q) {
        
        List<Node> parentsP = new ArrayList<>();
        //List<Node> parentsQ = new ArrayList<>();
        parentsP.add(p);
        
        while (p.parent != null) {
            parentsP.add(p.parent);
            p = p.parent;
        }
        
    
        while (q != null) {
            if (parentsP.contains(q)) {
                return q;
            } 
            q = q.parent;
            
        }
        
        return null;
    }
}
