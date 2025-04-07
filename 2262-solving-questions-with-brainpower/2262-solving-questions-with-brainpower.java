class Solution {
    Long cache[];

    public long mostPoints(int[][] q) {
        cache = new Long[q.length + 1];
        return solve(q, 0);
    }

    public long solve(int[][] q, int i) {
        if (i >= q.length) return 0;

        if (cache[i] != null) return cache[i];

        int[] c = q[i];
        long take = c[0] + solve(q, i + c[1] + 1);
        long skip = solve(q, i + 1);

        return cache[i] = Math.max(take, skip);
    }
}
