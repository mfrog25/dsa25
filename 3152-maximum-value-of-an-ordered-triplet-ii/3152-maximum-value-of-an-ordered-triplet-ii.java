class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] rmax = new int[n];
        rmax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) rmax[i] = Math.max(nums[i + 1], rmax[i + 1]);

        int lMax = nums[0];
        long res = 0;

        for (int i = 1; i < n - 1; i++) {
            System.out.println(lMax);
            long temp = (long) (lMax - nums[i]) * rmax[i];
            res = Math.max(temp, res);
            lMax = Math.max(lMax, nums[i]);
        }

        return res;
    }
}
