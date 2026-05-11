/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var res = 0
    fun maxPathSum(root: TreeNode?): Int {
        res = root?.`val` ?: 0
        dfs(root)
        return res        
    }

    fun dfs(root:TreeNode?) : Int {
        if(root == null)
           return 0
        var leftMax = max(0,dfs(root.left))
        var rightMax = max(0,dfs(root.right))
        res = max(res,root.`val`+leftMax+rightMax)
        return root.`val` + max(leftMax,rightMax)   
    }
}
