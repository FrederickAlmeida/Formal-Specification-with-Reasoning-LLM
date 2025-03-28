public class ReLUSeq {
    //@ ensures \result >= 0;
    //@ ensures \result == x ==> x >= 0;
    //@ ensures \result == 0 ==> x <= 0;  
    public static double computeReLU(double x) {
        return ((x >= 0) ? x : 0);
    }
}
