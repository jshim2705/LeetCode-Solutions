#include <vector>
using namespace std;

class Solution {
public:
    vector<int> x = {+1, -1, 0, 0};
    vector<int> y = {0, 0, +1, -1};
    void dfs(int i,int j,vector<vector<char>>& grid,vector<vector<bool>>& visited)
    {
        int n = grid.size();
        int m = grid[0].size();
        if(i < 0 || j < 0 || i > n-1 || j > m-1)//boundary conditions
        {
            return;
        }
        if(grid[i][j] == '1' && visited[i][j] == false)//if not visited yet lets visit them
        {
            visited[i][j] = true;
            for(int k=0; k<4; k++)//combination to check in all 4 directions
            {
                int newR = i+x[k];
                int newC = j+y[k];
                dfs(newR, newC, grid,visited);
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n,vector<bool> (m,false));//visited matrix
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1')
                {
                    if(visited[i][j] == false)
                    {
                        ans++;
                        dfs(i,j,grid,visited);
                    }
                }
            }
        }
        return ans;
    }
};
