class MinInArray {
    //@ requires arr != null;
    //@ ensures arr.length == 0 ==> \result == -1;
    //@ ensures (\forall int i; 0 <= i && i < arr.length; \result <= arr[i]);
    public int minElementInArray(int[] arr) {
        if (arr.length == 0) return -1;
        int res = Integer.MAX_VALUE;
        //@ maintaining (\forall int j; 0 <= j && j < i; res <= arr[j]);
        //@ maintaining 0 <= i && i <= arr.length;
        //@ decreases arr.length - i;
        for(int i = 0; i < arr.length; i++) {
            res = ((arr[i] < res) ? arr[i] : res);
        }
        return res;
    }
}
