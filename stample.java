package leetcode amazon-OA;

/**
 * Project Name : Leetcode
 * Package Name : leetcode amazon-OA
 * File Name : LongestSubstringwithAtMostKDistinctCharacters
 * Creator : Xiaosong
 * Date : M, 2019
 * Description : 973. K Closest Points to Origin
 */

    /**

     * @param s
     * @param k
     * @return
     */

   class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, new Comparator<int []>(){
            public int compare(int[] a, int[] b) {
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        });
        
        for (int[] point: points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        int [][] res = new int[k][2];
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}