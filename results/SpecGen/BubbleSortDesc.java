public class BubbleSortDesc { 
    
    //@ requires 0 <= x && x < array.length && 0 <= y && y < array.length;
    //@ modifies array[x], array[y];
    //@ ensures array[x] == \old(array[y]) && array[y] == \old(array[x]);
    void swap(int x, int y,  int array[]) {
        int temp;     
        temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //@ requires arr != null;
 
    int[] bubbleSort(int arr[]) {
        int n = arr.length;

        //@ maintaining 0 <= i && i - 1 <= n-1;  
        //@ decreasing n - 1 - i;
        for (int i = 0; i < n-1; i++) {	

            //@ maintaining 0 <= j && j <= n-i-1;
            //@ decreasing n - i - 1 - j;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j+1] > arr[j]) {  
		     swap(j, j + 1, arr); 
                } 
	    }
	} 
	return arr;
    } 
}