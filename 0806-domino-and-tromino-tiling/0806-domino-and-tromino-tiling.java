class Solution {
    int MOD = 1000000007;
    Integer cache[] = new Integer[1001];

    public int numTilings(int n) {
        return solve(n);
    }

    public int solve(int n) {
        if (n == 1 || n == 2) return n;

        if (n == 3) return 5;

        if (cache[n] != null) return cache[n];

        return cache[n] = ((2 * (solve(n - 1) % MOD) % MOD) + (solve(n - 3) % MOD)) % MOD;
    }
}
