class Solution {

    public int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int total = n * n;

        int[] parent = new int[total];
        int[] rank = new int[total];

        for (int i = 0; i < total; i++)
            parent[i] = i;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // Step 1: DSU union for all 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;

                int node = r * n + c;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        int adj = nr * n + nc;
                        union(node, adj, parent, rank);
                    }
                }
            }
        }

        // Step 2: Calculate size of each parent component
        Map<Integer, Integer> compSize = new HashMap<>();

        for (int i = 0; i < total; i++) {
            int p = find(i, parent);
            compSize.put(p, compSize.getOrDefault(p, 0) + 1);
        }

        int maxIsland = 0;

        // existing largest
        for (int size : compSize.values())
            maxIsland = Math.max(maxIsland, size);

        // Step 3: Try flipping 0 → 1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1) continue;

                Set<Integer> seen = new HashSet<>();
                int newSize = 1; // cell itself

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (isValid(nr, nc, n) && grid[nr][nc] == 1) {
                        int parentComp = find(nr * n + nc, parent);
                        if (seen.add(parentComp)) {
                            newSize += compSize.get(parentComp);
                        }
                    }
                }

                maxIsland = Math.max(maxIsland, newSize);
            }
        }

        return maxIsland;
    }
}
