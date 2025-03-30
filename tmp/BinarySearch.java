public class BinarySearch {

    //@ requires arr != null;
    //@ requires arr.length >= 0;
    //@ ensures \result == -1 <==> (arr.length == 0 || (\forall int i; 0 <= i && i < arr.length; arr[i] < key) || (\forall int i; 0 <= i && i < arr.length; arr[i] > key));
    //@ ensures \result >= 0 <==> (0 <= \result && \result < arr.length && arr[\result] == key);
    public static int Binary(int[] arr, int key) {
        if (arr.length == 0) {
            return -1;
        } else {
            int low = 0;
            int high = arr.length;
            int mid = high / 2;

            //@ maintaining 0 <= low && low <= high && high <= arr.length;
            //@ maintaining (\exists int i; 0 < i && i < arr.length; arr[i] != key ==> (i < low || i > high));  
            //@ decreases high + low;  
            while (low < high && arr[mid] != key) {
                if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                mid = low + (high - low) / 2;
            }
            if (low >= high) {
                return -1;
            }
            return mid;
        }
    }
}
