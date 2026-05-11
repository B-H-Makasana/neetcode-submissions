class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
       var res = mutableListOf<List<Int>>()
       var subList = mutableListOf<Int>()
       candidates.sort()
       fun backTrack(index:Int,total:Int) { 
           if(total == target) {
              res.add(subList.toList())
              return
           }
           if(index>=candidates.size || total>target) {
              return
           }
           
           subList.add(candidates[index])
           backTrack(index+1,total+candidates[index])
           subList.removeLast()
           var i = index +1
           while(i<candidates.size && candidates[i] == candidates[index])
           {
             i++ 
           }
           backTrack(i,total)
         }

       backTrack(0,0)
       return res
      }
}
