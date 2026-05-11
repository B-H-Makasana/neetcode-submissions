class MinStack() {
   
    var stack = mutableListOf<Int>()
    var minStack = mutableListOf<Int>()
    fun push(`val`: Int) {
       stack.addLast(`val`)
       if(minStack.isNotEmpty()) {
          minStack.addLast(minOf(`val`,minStack.last()))
       } else {
         minStack.addLast(`val`)
       }
    }

    fun pop() {
      stack.removeLast()
      minStack.removeLast()
    }

    fun top(): Int {
       return stack.last()
    }

    fun getMin(): Int {
       return minStack.last()
    }
}
