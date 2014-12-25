package tree;

import other.TestMain.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0
        		|| postorder == null || postorder.length == 0) {
        	return null;
        }
        
        int inStart = 0;
        int postStart = 0;
        int inEnd = inorder.length - 1;
        int postEnd = postorder.length - 1;
        return build(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
    
    public static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    	if (inStart > inEnd || postStart > postEnd) {
    		return null;
    	}
    	int rootVal = postorder[postEnd];
    	TreeNode root = new TreeNode(rootVal);
    	
    	int mid = inStart;
    	while(inorder[mid] != rootVal) {
    		mid++;
    	}
    	
    	root.left = build(inorder, inStart, mid - 1, postorder, postStart, postStart + mid - 1 - inStart);
    	root.right = build(inorder, mid + 1, inEnd, postorder, postStart + mid - inStart, postEnd - 1);
    	return root;
    }
}
