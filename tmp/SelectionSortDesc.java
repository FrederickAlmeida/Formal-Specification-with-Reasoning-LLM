public class SelectionSortDesc {

    //@ requires arr != null;
    //@ requires arr.length > 0;
    //@ ensures (\exists int i; 0 < i && i < arr.length - 1;   
    //@           (\forall int j; 0 <= j && j < arr.length; 
    //@               (arr[i] >= arr[j]))); // arr is sorted in descending order
    public static void selectionSort(int[] arr) {  
        for (int i = 0; i < arr.length - 1; i++) {  
            int index = i;  
            //@ maintaining (0 <= index && index <= arr.length - 1);
            //@ maintaining (\forall int k; i <= k && k < j; arr[k] <= arr[index]);
            //@ decreases arr.length - j;
            for (int j = i + 1; j < arr.length; j++) {  
                if (arr[j] > arr[index]) {  
                    index = j;
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }
}
