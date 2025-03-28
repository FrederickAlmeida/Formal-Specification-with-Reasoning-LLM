public class UniqueNumNested {
    //@ requires arr != null && arr.length > 0 && (\forall int i; 0 <= i && i < arr.length; Integer.MIN_VALUE <= arr[i] && arr[i] <= Integer.MAX_VALUE);
    //@ ensures \result == -1 || (0 < \result && \result < arr.length || (\exists int j; 0 <= j && j < arr.length; j != \result ==> arr[\result] != arr[j]));  
    public static int uniqueNum(int[] arr) {
        //@ maintaining 0 <= i && i <= arr.length;
 
        //@ decreases arr.length - i;
        for (int i = 0; i < arr.length; ++i) {
            int j = 0;
            //@ maintaining i + 1 <= j && j <= arr.length;
            //@ maintaining (\forall int k; i < k && k < j; arr[i] != arr[k]);  
            //@ decreases arr.length - j;
            for (j = i + 1; j < arr.length; ++j) {
                if(arr[i] == arr[j])
                    break;
            }
            if(j == arr.length)
                return i;
        }
        return -1;
    }
    
}