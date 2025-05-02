class Solution {

    public String pushDominoes(String d) {
        return solve(new StringBuilder(d));
    }

    public String solve(StringBuilder input) {
        boolean flag = true;

        while (flag) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder(input);
            for (int i = 1; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '.') {
                    char left = input.charAt(i - 1);
                    char right = input.charAt(i + 1);

                    if ((left == '.' || left == 'L') && right == 'L') {
                        sb.setCharAt(i, 'L');
                        cnt++;
                    } else if (left == 'R' && (right == '.' || right == 'R')) {
                        sb.setCharAt(i, 'R');
                        cnt++;
                    }
                }
            }

            input = sb;

            if (cnt == 0) flag = false;
        }

        if (input.length() > 1) {
            if (input.charAt(0) == '.' && input.charAt(1) == 'L') input.setCharAt(0, 'L');
            if (input.charAt(input.length() - 1) == '.' && input.charAt(input.length() - 2) == 'R') input.setCharAt(input.length() - 1, 'R');
        }

        return input.toString();
    }
}
