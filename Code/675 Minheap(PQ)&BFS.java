
/**
 * Project Name : Leetcode-Amazon
 * Package Name : leetcode-XS
 * File Name : LeetCode 675. Cut Off Trees for Golf Event
 * Creator : Seawill-XS
 * Date : Mar, 2019
 * Description : MinHeap + BFS
 */


class Solution {
    
    // direction  右左下上 移动方向
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    
    // 构建 怕徐方法  sort ==> min Heap  PriorityQueue 
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
    // put all node >= 2 in the pq,  (auto sorted)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        
    // poll out the node in order (cut tree in order) sum the distance
        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, m, n);
            
            if (step < 0) return -1;
            sum += step;
            
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }
    
    
    // min step method  最小路径 计算方法 ==> BFS
    
    private int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if(curr[0] == tree[0] && curr[1] == tree[1]) return step;
                
                for (int[] d: dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step ++;
        }
        return -1;
    }
} 
