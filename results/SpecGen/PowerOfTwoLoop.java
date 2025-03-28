class PowerOfTwoLoop {
    //@ requires n > 0;
    //@ ensures \result == true || \result == false;
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        //@ maintaining n > 0;
        //@ maintaining n % 2 == 0 ==> n/2 > 0;
        //@ decreases n;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}

