/**

LeetCode 530  783

		author : xs lyu
		march 2019
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

  //递归
class Solution {
    Integer res = Integer.MAX_VALUE, prev = null;
    public int minDiffInBST(TreeNode root) {
       if (root.left != null) minDiffInBST(root.left);
       // 距离上一个点的距离   最小值
        if (prev != null) res = Math.min(res, root.val - prev);
        prev = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}