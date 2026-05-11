/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var array = mutableListOf<Int>()

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfs(root)
        return array[k-1]
    }

    fun dfs(root:TreeNode?) {
        if(root == null) {
            return 
        }
        dfs(root.left)
        array.add(root.`val`)
        dfs(root.right)
    }
}
