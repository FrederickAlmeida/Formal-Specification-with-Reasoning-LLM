public class Smallest {

    //@ requires a != null;
    //@ requires a.length >= 0;
 
    //@ ensures 0 <= \result && \result < a.length ==> (\forall int i; 0 <= i && i < a.length; a[i] >= a[\result]);
    static public int Smallest(int[] a) {
        if (a.length == 0) return -1;

        int index = 0;
        int smallest = 0;

        //@ maintaining 0 <= index && index <= a.length;
        //@ maintaining (\forall int i; 0 <= i && i < index; a[i] >= a[smallest]);
        //@ decreases a.length - index;
        while (a.length - index > 0) {
            //@ assume 0 <= index && index < a.length; // Ensure index is within bounds
            //@ assume 0 <= smallest && smallest < a.length; // Ensure smallest is within bounds
            if (a[index] < a[smallest]) {
                smallest = index;
            }
            index = index + 1;
        }
        return smallest;
    }
}
