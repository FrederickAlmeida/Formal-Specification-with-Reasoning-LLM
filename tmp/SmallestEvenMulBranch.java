class SmallestEvenMulBranch {
    /*@ requires n >= 0; 
      @ ensures \result == n <==> (n % 2 == 0);
 
      @*/
    public int smallestEvenMultiple(int n) {
        if(n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }
}
