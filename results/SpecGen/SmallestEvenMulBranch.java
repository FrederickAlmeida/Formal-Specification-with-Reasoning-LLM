class SmallestEvenMulBranch {
    //@ requires n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE;
    //@ ensures (n % 2 == 0) ==> (\result == n);
    //@ ensures (n % 2 != 0) ==> (\result == 2 * n);
    public int smallestEvenMultiple(int n) {
        if(n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }
}

