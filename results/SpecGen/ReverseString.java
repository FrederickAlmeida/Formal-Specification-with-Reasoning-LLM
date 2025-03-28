class ReverseString {
    //@ requires s != null;
 
    public void reverseString(char[] s) {
        int n = s.length;
        //@ maintaining 0 <= left && left - 1 <= right && right < n;  
 
 
        //@ decreases right - left;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}

