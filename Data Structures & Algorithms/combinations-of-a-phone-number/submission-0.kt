class Solution {
    fun letterCombinations(digits: String): List<String> {
       if(digits.isEmpty()) return emptyList()
       var input = mutableListOf<String>()   
       var res = mutableListOf<String>()
       var digit = digits.toInt()
       while(digit>0) {
        when(digit%10) {
          2 -> input.add("abc")
          3 -> input.add("def")
          4 -> input.add("ghi")
          5 -> input.add("jkl")
          6 -> input.add("mno")
          7 -> input.add("pqrs")
          8 -> input.add("tuv")
          9 -> input.add("wxyz")
        }
        digit = digit/10
       }
       input.reverse()
      
       fun dfs(index:Int,cur:String) {
         if(index > digits.length) {
            return
         }
         if(digits.length == cur.length) {
            res.add(cur)
            return
         }
         for(c in input[index]) {
            dfs(index+1,cur+c)
         }
       }

       dfs(0,"")
       return res
    }

}
