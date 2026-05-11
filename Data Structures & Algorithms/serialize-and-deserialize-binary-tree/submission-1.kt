/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
       var res = mutableListOf<String>()

       fun dfs(root:TreeNode?) {
           if(root == null) {
              res.add("N")
              return 
           } else  {
              res.add(root.`val`.toString())
              dfs(root.left)
              dfs(root.right)
            }
        }
        
       dfs(root)
       return res.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
       val input = data.split(",")

       var i = 0
       fun dfs() : TreeNode? {
        if(input[i] == "N") {
            i++
            return null
        } else {
           var node = TreeNode(input[i].toInt())
           i++
           node.left = dfs() 
           node.right = dfs()
           return node
          }
        }    
       return dfs()
    }
}
