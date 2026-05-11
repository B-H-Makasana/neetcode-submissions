class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        var stack = mutableListOf<Int>()
        for(i in tokens) {
            if(i.toIntOrNull() != null) {
                stack.addLast(i.toInt())
            } else if(i == "+") {
               stack.addLast(stack.removeLast() + stack.removeLast())
            } else if(i == "/") {
                var first = stack.removeLast()
                var second = stack.removeLast()
               stack.addLast(second / first)
            } else if(i == "*") {
               stack.addLast(stack.removeLast() * stack.removeLast())
            } else if(i == "-") {
                var first = stack.removeLast()
                var second = stack.removeLast()
               stack.addLast(second - first)
            }
        }
        return stack.last()
    }
}
