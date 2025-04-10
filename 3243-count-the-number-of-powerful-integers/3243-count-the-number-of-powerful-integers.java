class Solution {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return solve(String.valueOf(finish), s, limit) - solve(String.valueOf(start - 1), s, limit);
    }

    public long solve(String curr, String suff, int limit) {
        if (curr.length() < suff.length()) return 0;

        long count = 0;

        int remL = curr.length() - suff.length();

        for (int i = 0; i < remL; i++) {
            int digit = curr.charAt(i) - '0';

            if (digit <= limit) {
                count += digit * Math.pow(limit + 1, remL - i - 1);
            } else {
                count += Math.pow(limit + 1, remL - i);
                return count;
            }
        }

        String trail = curr.substring(curr.length() - suff.length()); // curr 1234 suff = 10 --> 34
        if (Long.valueOf(trail) >= Long.valueOf(suff)) count += 1;

        return count;
    }
}
