public class ReLU {
    //@ ensures \result > 0 ==> \result == x;  
    //@ ensures \result < 0 ==> \result == 0.0;
    public static double computeReLU(double x) {
        if(x >= 0) {
            return x;
        }
        return 0.0;
    }
}
