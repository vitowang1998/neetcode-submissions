class Solution {
    private static final int[][] dirs = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private int bfs(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        grid[r][c] = id;
        int area = 0;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            area ++;

            for (int[] dir: dirs) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = id;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return area;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> areasByIslandId = new HashMap<>();
        int islandId = 2;
        int res = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = bfs(grid, r, c, islandId);
                    areasByIslandId.put(islandId, area);
                    res = Math.max(res, area);
                    islandId++;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != 0) continue;

                int area = 1;
                Set<Integer> seen = new HashSet<>();
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    int id = grid[nr][nc];

                    if (id > 1 && seen.add(id)) {
                        area += areasByIslandId.get(id);
                    }
                }

                res = Math.max(res, area);
            }
        }

        return res;
    }
}
