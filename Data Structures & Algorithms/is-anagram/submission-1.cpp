class Solution {
public:
    bool isAnagram(string s, string t) {
          unordered_map<char, int> umap;
          for(int i=0;i<s.length();i++) {
            umap[s[i]] = umap[s[i]] + 1;
          }
          for(int j=0;j<t.length();j++) {
            umap[t[j]] = umap[t[j]] -1;
          }
          for(auto k:umap) {
            if(k.second != 0) {
                return false;
            }
          }
          return true;
    }
};
