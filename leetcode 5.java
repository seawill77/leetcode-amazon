package leetcode amazon-OA;

/**
 * Project Name : Leetcode 5
 * Package Name : leetcode amazon-OA
 * File Name : 5. Longest Palindromic Substring
 * Creator : Xiaosong
 * Date : M, 2019
 * Description : dp  && centeral scann
 */

    /**

     * @param s
     * @param k
     * @return
     */

// cneter scann
class Solution {
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //notcie left and right executed extra --  ++   so String cur = s.substring(left + 1, right -1 + 1)
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
}


dp: 


class Solution {
    public String longestPalindrome(String s) {
       if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
            	// (j - i <= 2)  means when   i j 中间只剩 1个 或两个数  则  dp[i + 1][j - 1] 不一定成立 
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
