/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
         val res: MutableList<Int> = mutableListOf()
         if(root == null) return emptyList()
         var q : MutableList<TreeNode?> = mutableListOf(root)

        while(q.isNotEmpty()) {
            var qSize = q.size
            val levelList = mutableListOf<Int>()
            for(i in 0 until qSize) {
                val i = q.removeFirst()
                levelList.add(i!!.`val`)
                if(i?.left!=null)
                  q.add(i?.left)
                if(i?.right!=null) 
                   q.add(i?.right)
            }
            res.add(levelList.last())
        }
        return res  
    }
}
