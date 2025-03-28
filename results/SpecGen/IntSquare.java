public class IntSquare {

    //@ requires x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE;
 
 
    public static int squareOf(int x) {
        if(x < 0)
            x = -x;
        int res = 0;
        //@ maintaining 0 <= i && i <= x;
 
        //@ decreases x - i;
        for(int i = 0; i < x; i++) {
            //@ maintaining 0 <= j && j <= x;
 
            //@ decreases x - j;
            for(int j = 0; j < x; j++) {
                res = res + 1;
            }
        }
        return res;
    }

}