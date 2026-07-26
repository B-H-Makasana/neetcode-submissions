class Solution {
    fun checkValidString(s: String): Boolean {
        var leftMax = 0
        var leftMin = 0

        for(i in s) {
            if(i == '(') {
                leftMax ++
                leftMin ++
            }
            else if(i == ')') {
                leftMax --
                leftMin --
            } else {
                leftMax ++
                leftMin --
            }
            if(leftMax<0) {
                return false
            }
            if(leftMin<0) {
                leftMin = 0
            }
        }

        return (leftMin == 0 || leftMax==0)
    }
}
