class Solution {
    Boolean cache[][];

    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) sum += i;

        if (sum % 2 != 0) return false;

        cache = new Boolean[nums.length + 1][sum + 1];

        return solve(sum / 2, nums, 0, 0);
    }

    public boolean solve(int target, int nums[], int i, int curr) {
        if (curr == target) return true;
        if (curr > target || i >= nums.length) return false;

        if (cache[i][curr] != null) return cache[i][curr];

        return cache[i][curr] = solve(target, nums, i + 1, curr + nums[i]) || solve(target, nums, i + 1, curr);
    }
}
