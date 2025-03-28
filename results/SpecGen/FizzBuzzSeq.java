class FizzBuzzSeq {
    //@ requires Integer.MIN_VALUE <= n && n <= Integer.MAX_VALUE;
    //@ ensures \result == (n % 3 == 0 ? 3 : 0) + (n % 5 == 0 ? 5 : 0);
    public int fizzBuzz(int n) {
        int res = 0;
        res += ((n % 3 == 0) ? 3 : 0);
        res += ((n % 5 == 0) ? 5 : 0);
        return res;
    }
}

