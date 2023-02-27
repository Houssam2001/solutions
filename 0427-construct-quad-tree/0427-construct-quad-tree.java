class Solution {
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }
    
    private Node buildQuadTree(int[][] grid, int x, int y, int size) {
        if (size == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }
        
        int newSize = size / 2;
        Node topLeft = buildQuadTree(grid, x, y, newSize);
        Node topRight = buildQuadTree(grid, x, y + newSize, newSize);
        Node bottomLeft = buildQuadTree(grid, x + newSize, y, newSize);
        Node bottomRight = buildQuadTree(grid, x + newSize, y + newSize, newSize);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
           ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
            (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
