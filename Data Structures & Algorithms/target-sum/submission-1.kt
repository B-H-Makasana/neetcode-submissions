class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var cache = HashMap<Pair<Int,Int>,Int>()

        fun dfs(i:Int,sum:Int) : Int {
            if(i == nums.size) {
                return if(sum == target) 1 else 0
            }
            if(i>=nums.size) {
                return 0
            }
            if(cache.contains(Pair(i,sum))) {
               return cache[Pair(i,sum)]!!
            }
            cache[Pair(i,sum)] = dfs(i+1,sum + nums[i]) +  dfs(i+1,sum - nums[i])
            return cache[Pair(i,sum)]!!
        }

        return dfs(0,0)
    }
}