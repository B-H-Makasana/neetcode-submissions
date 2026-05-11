class Twitter() {
     
     val followedList = mutableMapOf<Int,MutableSet<Int>>()
     val postList = mutableMapOf<Int,MutableList<Pair<Int,Int>>>()

    var count = 0
    fun postTweet(userId: Int, tweetId: Int) {
        if(!postList.containsKey(userId)) {
            postList[userId] = mutableListOf()
        } 
        postList[userId]!!.add(Pair(tweetId,count))
        count ++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val resultList: MutableList<Pair<Int,Int>> = mutableListOf()
        postList[userId]?.let {resultList.addAll(it)}
        followedList[userId]?.forEach { it ->
            postList[it]?.let {resultList.addAll(it)}
        }
        return resultList.sortedByDescending {it.second} .take(10).map{it.first}
    }

    fun follow(followerId: Int, followeeId: Int) {
        if(followerId != followeeId) {
        if(!followedList.containsKey(followerId)) {
            followedList[followerId] = mutableSetOf()
        } 
        followedList[followerId]!!.add(followeeId)
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followedList[followerId]?.remove(followeeId)
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */