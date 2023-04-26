package dynamic.programming;

public class LongestCommonSubsequence {

    public static void main (String [] args){

        System.out.println("Longest Common Subsequence: " +
                getLCSLength("ABCBDAB".toCharArray(), 0, 7, "BDCABA".toCharArray(), 0, 6));
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
}
