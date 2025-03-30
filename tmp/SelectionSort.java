public class SelectionSort {

    /*@
      @ requires arr != null;
      @ requires arr.length > 0;
      @ ensures (\exists int i; 0 < i && i < arr.length - 1;   
      @           (\forall int j; 0 <= j && j < arr.length; arr[i] <= arr[j]));
      @*/
    public static void selectionSort(int[] arr) {  
        /*@
          @ loop_invariant 0 <= i && i < arr.length;
          @ loop_invariant (\forall int k; 0 <= k && k < i; arr[k] <= \old(arr[k]));
          @ decreases arr.length - 1 - i;
          @*/
        for (int i = 0; i < arr.length - 1; i++) {  
            int index = i;  
            /*@
              @ loop_invariant i + 1 <= j && j <= arr.length;
              @ loop_invariant (\forall int k; i + 1 <= k && k < j; arr[k] >= arr[index]);
              @ decreases arr.length - j;
              @*/
            for (int j = i + 1; j < arr.length; j++) {  
                if (arr[j] < arr[index]) {  
                    index = j;
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }
}
