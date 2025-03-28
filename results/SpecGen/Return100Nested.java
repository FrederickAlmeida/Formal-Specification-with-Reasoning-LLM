public class Return100Nested {
 
    public static int return100 () {
        int res = 0;
 
        //@ decreasing 10 - i;
        for(int i = 0; i < 10; i++) {
 
            //@ decreasing 10 - j;
            for(int j = 0; j < 10; j++) {
                res = res + 1;
            }
        }
        return res;
    }
}
