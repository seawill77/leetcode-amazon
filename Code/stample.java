package leetcode amazon-OA;

/**
 * Project Name : Leetcode 5
 * Package Name : leetcode amazon-OA
 * File Name : 5. Longest Palindromic Substring
 * Creator : Xiaosong
 * Date : M, 2019
 * Description : 973. K Closest Points to Origin
 */

    /**

     * @param s
     * @param k
     * @return
     */

   // 中心扩散法
  class Solution {
    
    // global  for  class helper recoard
    String res = "";
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        for (int i = 0; i < s.length(); i++) {
            //two situation    aba   abba  
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

        // it should be  s.substring (left + 1, ritght + 1 - 1) because in while loop it has estra left -- and right ++;
        String cur = s.substring(left + 1, right);
            if (cur.length() > res.length()) {
            res = cur;
            }
    }
}


// dynamic programing
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        int max = 0;
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        
        for (int j = 0; j < l; j++) {
            for (int i = 0; i <= j; i++) {

                //   (j - i <= 2)   cauz if  a  b  a      a b b a
                                         //  i     j        i j       j - 1 =  2, 1 , 0
                                        //   0  1  2      0 1 2 3  
                    //make no sence            ij    and    j i         without this   code will out of boundary;
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
