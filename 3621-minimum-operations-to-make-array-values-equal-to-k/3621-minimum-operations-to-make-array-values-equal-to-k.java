class Solution {

    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        int val = 0;
        for (int i : nums) {
            if (i < k) return -1;
            set.add(i);
            if (i == k) val = 1;
        }

        return (val == 1) ? set.size() - 1 : set.size();
    }
}
