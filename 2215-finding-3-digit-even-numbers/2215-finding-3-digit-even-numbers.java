class Solution {

    public int[] findEvenNumbers(int[] d) {
        Arrays.sort(d);
        Set<Integer> set = new HashSet();
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 0) continue;
            int curr = d[i];
            for (int j = 0; j < d.length; j++) {
                if (i == j) continue;
                int jcurr = curr * 10 + d[j];
                for (int k = 0; k < d.length; k++) {
                    if (k == j ) continue;
                    if(k == i) continue;
                    if (d[k] % 2 == 0) set.add(jcurr * 10 + d[k]);
                }
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
