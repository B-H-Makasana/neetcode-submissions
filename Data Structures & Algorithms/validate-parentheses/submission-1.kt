class Solution {
    fun isValid(s: String): Boolean {
       var stack = mutableListOf<Char>()
       for(c in s) {
          if(c in listOf('(','{','[')) {
            stack.add(c)
          } 
          else if(stack.size > 0) {
           if(c == ')' && stack.get(stack.size-1) == '(') {
               stack.removeAt(stack.size-1)
          }
          else if(c == '}' && stack.get(stack.size-1) == '{') {
               stack.removeAt(stack.size-1)
          } 
           else if(c == ']' && stack.get(stack.size-1) == '[') {
                stack.removeAt(stack.size-1)
           } 
           else {
                stack.add(c)
           }
          }
          else {
                stack.add(c)
          }
        }
        if(stack.isEmpty()) {
            return true
        } else {
            return false
        }
    }
}
