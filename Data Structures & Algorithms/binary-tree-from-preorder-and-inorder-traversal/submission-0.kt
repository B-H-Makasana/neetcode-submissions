/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if(preorder.isEmpty() || inorder.isEmpty()){
            return null
        }
        var root = preorder[0] 
        var mid = inorder.indexOf(root)
        var treeNode = TreeNode(root)
        treeNode.left = buildTree(preorder.sliceArray(1..mid),inorder.sliceArray(0 until mid))
        treeNode.right = buildTree(preorder.sliceArray(mid+1 until preorder.size),inorder.sliceArray(mid+1 until inorder.size))
        return treeNode
    }
}
