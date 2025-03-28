class TwoSum {
    //@ requires nums != null;
    //@ ensures \result != null;
    //@ ensures \result.length == 2 ==> nums[\result[0]] + nums[\result[1]] == target;
    //@ ensures \result.length == 0 ==> (\forall int i; 0 <= i && i < nums.length; (\forall int j; i + 1 <= j && j < nums.length; nums[i] + nums[j] != target));
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        //@ maintaining 0 <= i && i <= n;
        //@ maintaining (\forall int k; 0 <= k && k < i; (\forall int j; k + 1 <= j && j < n; nums[k] + nums[j] != target));
        //@ decreases n - i;
        for (int i = 0; i < n; ++i) {
            //@ maintaining i + 1 <= j && j <= n;
            //@ maintaining (\forall int k; 0 <= k && k < i; (\forall int l; i <= l && l < n; nums[k] + nums[l] != target));
            //@ maintaining (\forall int k; i < k && k < j; nums[i] + nums[k] != target);  
            //@ decreases n - j;
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}