class PowerOfTwoLoop {
    //@ requires Integer.MIN_VALUE <= n && n <= Integer.MAX_VALUE;
 
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        //@ maintaining n > 0;
        //@ decreases n;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}

