/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun dfs(root:TreeNode?,left:Long,right:Long) : Boolean {
        if(root == null) 
          return true
        val value = root.`val`.toLong()
        if(value <=left || value >= right) {
            return false
        }  
        return dfs(root.left,left,value) && dfs(root.right,value,right)
    }
}