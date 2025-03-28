class SmallestEvenMul {
    //@ requires n >= 0;
    //@ ensures \result >= n;
    //@ ensures (\result % 2 == 0) && (\result % n == 0);
    public int smallestEvenMultiple(int n) {
        //@ assume n != 0;
        return n % 2 == 0 ? n : 2 * n;
    }
}

