class Solution {
    fun generateParenthesis(n: Int): List<String> {
         var res = mutableListOf<String>()
         var stack = mutableListOf<String>()

         fun backTrack(openN:Int,closeN:Int) {
            if(openN == n && closeN == n) {
                res.add(stack.toList().joinToString(""))
                return
            }
            if(openN < n) {
                stack.add("(")
                backTrack(openN+1,closeN)
                stack.removeLast()
            }
            if(openN>closeN) {
                stack.add(")")
                backTrack(openN,closeN+1)
                stack.removeLast()
            }
         }

         backTrack(0,0)
         return res
    }
}
