/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var diameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
         if(root == null) return 0
         diameter = max(diameter, dfs(root.left) + dfs(root.right))
         diameterOfBinaryTree(root.left)
         diameterOfBinaryTree(root.right)

         return diameter
    }

    fun dfs(root:TreeNode?) : Int {
        if(root == null) return 0
        else 
        return 1 + max(dfs(root.left),dfs(root.right))
    }
}
