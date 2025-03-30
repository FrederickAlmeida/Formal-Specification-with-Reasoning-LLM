public class MaxBad {

    //@ ensures \result >= i && \result >= j && \result >= k;
    //@ ensures \result == i || \result == j || \result == k;
    public static int max(int i, int j, int k) {
        int t = i > j ? i : j;
        //@ assert t >= i && t >= j; // t is the maximum of i and j
        return t > k ? t : k; // return the maximum of t and k
    }
}