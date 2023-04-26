package dynamic.programming;

public class LongestCommonSubsequence {

    public static void main (String [] args){

        System.out.println("Longest Common Subsequence: " +
                getLCSLength("ABCBDAB".toCharArray(), 0, 7, "BDCABA".toCharArray(), 0, 6));

        System.out.println("Longest Common Subsequence using DPP: " +
                getLCSLengthUsingDPP("ABCBDAB".toCharArray(), 7, "BDCABA".toCharArray(), 6));

    }

    public static int getLCSLength(char[] x, int i, int m, char[] y, int j, int n){
        if(i == m || j == n){
            return 0;
        }
        if(x[i] == y[j]){
            return 1 + getLCSLength(x, i+1, m, y, j+1, n);
        }else{
            return Math.max(getLCSLength(x, i+1, m, y, j, n), getLCSLength(x, i, m, y, j+1, n));
        }
    }

    public static int getLCSLengthUsingDPP(char[] x, int m, char[] y, int n){

        int [][] lCS = new int[1024][1024];
        int i=0;
        int j=0;
        String longestCS = new String();
        for(; i<=n; i++){
            lCS[m][i] = 0;
        }
        for(; j<=m; j++){
            lCS[j][n] = 0;
        }
        for(i=m-1; i>=0; i--){
            for(j=n-1; j>=0; j--){
                lCS[i][j] = lCS[i+1][j+1];
                if(x[i] == y[j]){
                    lCS[i][j]++;
                    longestCS += x[i];
                }
                if(lCS[i][j+1] > lCS[i][j]){
                    lCS[i][j] = lCS[i][j+1];
                }
                if(lCS[i+1][j] > lCS[i][j]){
                    lCS[i][j] = lCS[i+1][j];
                }
            }
        }
        System.out.println(longestCS);
        return lCS[0][0];
    }
}
