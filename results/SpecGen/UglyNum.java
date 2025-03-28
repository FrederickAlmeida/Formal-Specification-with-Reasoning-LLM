class UglyNum {
    //@ requires n > 0;
    //@ ensures \result ==> (\exists int i; 0 < i && i <= 3; n % 2 == 0 && n % 3 == 0 && n % 5 == 0) || n == 1;  
    //@ ensures !\result ==> (\forall int i; 0 <= i && i <= 3; n % 2 == 0 && n % 3 == 0 || n % 5 == 0) && n != 1;  
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        for (int factor : new int[]{2, 3, 5}) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}