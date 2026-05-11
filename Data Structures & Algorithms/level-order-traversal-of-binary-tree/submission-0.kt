/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
         val res: MutableList<List<Int>> = mutableListOf()
         if(root == null) return emptyList()
         res.add(listOf(root!!.`val`))
         var currentList : List<TreeNode?> = listOf()
        currentList = listOf(root)

        while(currentList.isNotEmpty()) {
            var subList:MutableList<TreeNode?> = mutableListOf()
            for(i in currentList) {
                if(i?.left!=null)
                  subList.add(i?.left)
                if(i?.right!=null) 
                   subList.add(i?.right)
            }
            if(subList.isNotEmpty()) 
               res.add(subList.mapNotNull { it?.`val` })
            currentList = subList.toList()
        }
        return res
    }
} 
