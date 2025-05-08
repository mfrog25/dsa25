class Solution {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minTimeToReach(int[][] mt) {
        int[][] res = new int[mt.length][mt[0].length];
        boolean[][] visited = new boolean[mt.length][mt[0].length];

        for (int a[] : res) Arrays.fill(a, Integer.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.add(new State(0, 0, 0, 1));
        res[0][0] = 0;

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int x = curr.x, y = curr.y;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int d[] : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= mt.length || nx < 0 || ny >= mt[0].length || ny < 0) continue;

                int prev = curr.prev;
                int time = curr.time;

                int nextMinTime = mt[nx][ny];
                int total = Math.max(time, nextMinTime) + prev;

                res[nx][ny] = Math.min(res[nx][ny], total);

                int nextPrev = prev == 1 ? 2 : 1;

                pq.add(new State(nx, ny, total, nextPrev));
            }
        }

        return res[mt.length - 1][mt[0].length - 1];
    }
}

class State {
    int x, y, time, prev;

    State(int x, int y, int time, int prev) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.prev = prev;
    }
}
