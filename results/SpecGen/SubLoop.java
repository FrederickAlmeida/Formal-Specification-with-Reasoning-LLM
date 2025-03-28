public class SubLoop {
    //@ requires true;
    //@ ensures \result == x - y;
    public static int subLoop(int x, int y) {
        int sum = x;
        if (y > 0) {
            int n = y;
            //@ maintaining sum == x - (y - n);
            //@ maintaining n >= 0;
            //@ decreases n;
            while (n > 0) {
                sum = sum - 1;
                n = n - 1;
            }
        } else {
            int n = -y;
            //@ maintaining sum == x - (n + y);  
            //@ maintaining n >= 0;
            //@ decreases n;
            while (n > 0) {
                sum = sum + 1;
                n = n - 1;
            }
        }
        return sum;
    }
}
