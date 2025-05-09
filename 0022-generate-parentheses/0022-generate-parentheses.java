class Solution {
    List<String> res = new ArrayList();

    public List<String> generateParenthesis(int n) {
        solve(n, n, new StringBuilder());
        return res;
    }

    public void solve(int o, int c, StringBuilder sb) {
        if (o == 0 && c == 0) {
            res.add(sb.toString());
            return;
        }

        if (o == c) {
            sb.append('(');
            solve(o - 1, c, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (o > 0) {
                sb.append('(');
                solve(o - 1, c, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (c > 0) {
                sb.append(')');
                solve(o, c - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
