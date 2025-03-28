class IsOneBitCharacter {

    //@ requires bits != null;
    //@ requires (\forall int i; 0 <= i && i < bits.length; bits[i] == 0 || bits[i] == 1);
 
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
	//@ maintaining 0 <= i && i < n + 1;  
	//@ maintaining (\forall int j; 0 <= j && j < i; bits[j] == 0 || bits[j] == 1);
	//@ decreases n - i;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }
}

