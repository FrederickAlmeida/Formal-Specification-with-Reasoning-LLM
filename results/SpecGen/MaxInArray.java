class MaxInArray {
    //@ requires arr.length > 0;
    //@ ensures \forall int i; 0 <= i && i < arr.length; arr[i] <= \result;
    public int maxElementInArray(int[] arr) {
        if (arr.length == 0) return -1;
        int res = Integer.MIN_VALUE;
        //@ maintaining 0 <= i && i <= arr.length;
        //@ maintaining (\forall int j; 0 <= j && j < i; arr[j] <= res);
        //@ decreases arr.length - i;
        for(int i = 0; i < arr.length; i++) {
            res = ((arr[i] > res) ? arr[i] : res);
        }
        return res;
    }
}

