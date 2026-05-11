class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map <string,vector<string>> map;
        vector<vector<string>>result;

        for(int i = 0; i<strs.size();i++) {
           string s = strs[i];
           std::sort(s.begin(),s.end());
           
            //    map[s].push_back(strs[i]);
           
               map[s].push_back(strs[i]);
        }

        for(auto k:map) {
            result.push_back(k.second);
        }

        return result;
    }
};
