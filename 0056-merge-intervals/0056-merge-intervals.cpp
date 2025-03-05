class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        // 입력을 정렬
        // st, en
        vector<vector<int>> ret;
        sort(intervals.begin(),intervals.end());

        int st=intervals[0][0];
        int en=intervals[0][1];

        for(int i=1;i<intervals.size();++i){
            int a = intervals[i][0];
            int b = intervals[i][1];
            cout<<st<<" "<<en<<" "<<a<<" "<<b<<"\n";
            if(a<en && en<=b){
                en=b;
            }
            if(a<=en && en<=b){
                en=b;
            }
            if(en<a){
                ret.push_back({st,en});
                st=a;
                en=b;
            }
        }
        ret.push_back({st,en});

        return ret;
    }
};