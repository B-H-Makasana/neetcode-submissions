class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
      unordered_map<int,int> res;
      for(int i = 0; i<nums.size();i++) {
        res[nums[i]] = i;
      }

       for(int i = 0; i<nums.size();i++) {
         int diff = target - nums[i];
         if(res.count(diff) && res[diff] != i) {
            return {i,res[diff]};
         }
      }  
    }
};
