class Solution {

    public int minimumOperations(int[] nums) {
        int i = 0, cnt = 0;
        while (check(nums, i) != true) {
            i += 3;
            cnt++;
        }

        return cnt;
    }

    public boolean check(int[] nums, int k) {
        HashSet<Integer> set = new HashSet();
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) return false; else set.add(nums[i]);
        }

        return true;
    }
}
