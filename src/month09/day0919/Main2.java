package month09.day0919;

import java.util.Scanner;

/**
 * @hurusea
 */
public class Main2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        boolean res = solution(s, p);
        System.out.println(res);
    }

    private static boolean solution(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '+') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

//#include<iostream>
//using namespace std;
//        int res[10000][10000];
//        int main()
//        {
//        int n,m;
//        cin>>n>>m;
//        int dx[] ={0,1,0,-1},dy[]={1,0,-1,0};
//        for(int x=0,y=0,d=0,k=1;k<= n*m ;k++)
//        {
//        res[x][y]=k;
//        int a=x+dx[d],b=y+dy[d];
//        if(a<0||a>=n||b<0||b>=n||res[a][b])
//        {
//        d=(d+1)%4;
//        a=x+dx[d],b=y+dy[d];
//        }
//        x=a,y=b;
//        }
//        for(int i=0;i< n;i++)
//        for(int j=0;j< m;j++){
//        res[i][j]%=26;
//        if(res[i][j]==0) res[i][j]=26;
//        }
//        for(int i=0;i< n;i++)
//        {
//        for(int j=0;j< m;j++) cout<<char(res[i][j]+'0'+16)<<' ';
//        cout<<endl;
//        }
//        return 0;
//        }