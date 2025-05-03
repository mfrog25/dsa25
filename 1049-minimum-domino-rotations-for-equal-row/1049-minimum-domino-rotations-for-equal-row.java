class Solution {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            min = Math.min(min, solve(i, tops, bottoms));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int solve(int k, int[] t, int[] b) {
        int top = 0, bottom = 0, flag = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == k && b[i] == k) continue;
            if (t[i] == k || b[i] == k) {
                if (t[i] == k) top++;
                if (b[i] == k) bottom++;
            } else {
                flag = 1;
                break;
            }
        }

        return (flag == 1) ? Integer.MAX_VALUE : Math.min(top, bottom);
    }
}
