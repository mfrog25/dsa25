class Solution {

    public boolean isPalindrome(String s) {
        return solve(s.toLowerCase(), 0, s.length() - 1);
    }

    public boolean solve(String s, int i, int j) {
        while (isSpaceOrNonAlphanumeric(s.charAt(i)) && i < j) i++;
        while (isSpaceOrNonAlphanumeric(s.charAt(j)) && i < j) j--;

        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;

        return solve(s, i + 1, j - 1);
    }

    public boolean isSpaceOrNonAlphanumeric(char c) {
        return !((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'));
    }
}
