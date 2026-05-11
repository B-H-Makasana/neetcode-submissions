class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> prifix(nums.size());
        vector<int> suffix(nums.size());
        vector<int> res(nums.size());
        prifix[0] = 1;
        suffix[nums.size()-1] = 1;
        for(int i=1;i<nums.size();i++) {
            prifix[i] = nums[i-1] * prifix[i-1];
        }

        for(int i=nums.size()-2;i>=0;i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int r=0;r<nums.size();r++) {
            res[r] = prifix[r] * suffix[r];       
        } 
        return res;
    }
};
