package tree;

import other.TestMain.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0
        		|| inorder == null || inorder.length == 0) {
        	return null;
        }
        
        int preStart = 0;
        int inStart = 0;
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        return build(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
    
    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    	if (preStart > preEnd || inStart > inEnd) {
    		return null;
    	}
    	int rootVal = preorder[preStart];
    	TreeNode root = new TreeNode(rootVal);
    	
    	int mid = inStart;
    	while(inorder[mid] != rootVal) {
    		mid++;
    	}
    	
    	root.left = build(preorder, preStart + 1, preStart + mid - inStart, inorder, inStart, mid - 1);
    	root.right = build(preorder, preStart + mid - inStart + 1, preEnd, inorder, mid + 1, inEnd);
    	return root;
    }
}
