public class SetZero {

    //@ requires a != null;
    //@ requires 0 <= iBegin && iBegin <= iEnd && iEnd <= a.length;
 
    //@ ensures (\forall int j; 0 < j && j < iBegin && iEnd < j && j < a.length; a[j] == \old(a[j]));  
    public static void SetZero(int[] a, int iBegin, int iEnd) {
        int k = iBegin;

        //@ maintaining iBegin <= k && k <= iEnd;
        //@ decreases iEnd - k;
        while (k < iEnd) {
            a[k] = 0;
            k = k + 1;
        }
    }
}
