/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        return buildTree(pre, 0, pre.length - 1, preMirror, 0, preMirror.length - 1);
    }

    private Node buildTree(int[] pre, int preStart, int preEnd, 
                           int[] preMirror, int mirrorStart, int mirrorEnd) {
        if (preStart > preEnd) return null;

        Node root = new Node(pre[preStart]);
        
        // Single node case
        if (preStart == preEnd) return root;

        // Find the root of the left subtree in the preMirror array
        int leftRootVal = pre[preStart + 1];
        int idx = mirrorStart;
        while (idx <= mirrorEnd) {
            if (preMirror[idx] == leftRootVal) break;
            idx++;
        }

        // Calculate size of the left subtree
        int size = mirrorEnd - idx + 1;

        // Recursively build left and right subtrees
        root.left = buildTree(pre, preStart + 1, preStart + size, 
                              preMirror, idx, mirrorEnd);
                              
        root.right = buildTree(pre, preStart + size + 1, preEnd, 
                               preMirror, mirrorStart + 1, idx - 1);

        return root;
    }
}