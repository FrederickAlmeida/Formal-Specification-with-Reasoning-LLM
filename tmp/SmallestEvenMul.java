class SmallestEvenMul {
    //@ requires n > 0;
    //@ ensures \result == n <==> n % 2 == 0;
    //@ ensures \result == 2 * n <==> n % 2 != 0;
    //@ ensures \result > 0;
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}