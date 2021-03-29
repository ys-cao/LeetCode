

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
        
        if (parentsP.contains(q)) {
                return q;
            }
        
        while (q.parent != null) {
            
            if (parentsP.contains(q.parent)) {
                return q.parent;
            }
            
            q = q.parent;
        }
        
        return null;
    }
}
