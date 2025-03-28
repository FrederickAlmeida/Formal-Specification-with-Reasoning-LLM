public class AddLoopFor {
    //@ requires Integer.MIN_VALUE <= x + y && x + y <= Integer.MAX_VALUE && x != Integer.MIN_VALUE;
    //@ ensures \result == x + y;
    public static int addLoop(int x, int y) {
        int sum = y;
        if (x > 0) {
            //@ maintaining sum == y + (x - n) && 0 <= n && n <= x;
            //@ decreases n;
            for(int n = x; n > 0; n = n - 1) {
                sum = sum + 1;
            }
        } else {
            //@ maintaining sum == y + (x + n) && 0 <= n && n <= -x;  
            //@ decreases n;
            for(int n = -x; n > 0; n = n - 1) {
                sum = sum - 1;
            }
        }
        return sum;
    }
}