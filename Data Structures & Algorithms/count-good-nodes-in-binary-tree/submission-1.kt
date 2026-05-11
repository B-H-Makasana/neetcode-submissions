/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var gd = 0
    fun goodNodes(root: TreeNode?): Int {
         dfs(root,Int.MIN_VALUE)
         return gd
    }

    fun dfs(root:TreeNode?,max:Int) {
        if(root == null) {
            return 
        }
        var temp = max
        if(root.`val` >= temp)  {
        //    print("root value is ${root.`val`} anc temp is ${temp}") 
           gd += 1
           temp = root.`val`
        }
        dfs(root.left,temp)
        dfs(root.right,temp)
    }
}