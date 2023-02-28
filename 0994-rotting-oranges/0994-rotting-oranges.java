class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int x = rotten[0];
                int y = rotten[1];
                
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    
                    if (grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // mark as rotten
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
}
