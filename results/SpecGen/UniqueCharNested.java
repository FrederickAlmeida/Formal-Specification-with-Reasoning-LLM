public class UniqueCharNested {

 
    //@ ensures 0 < \result && \result < s.length() ==> (\exists int j; \result+1 - 1 <= j && j < s.length(); s.charAt(\result) == s.charAt(j));  
    public static int uniqueChar(String s) {
 
        //@ maintaining (0 <= i && i <= s.length());
        //@ decreases s.length() - i;
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            int j;
            //@ maintaining i+1 <= j && j <= s.length();
            //@ maintaining (\forall int k; i+1 <= k && k < j; s.charAt(i) != s.charAt(k));
            //@ decreases s.length() - j;
            for (j = i + 1; j < s.length(); ++j) {
                char c2 = s.charAt(j);
                if(c1 == c2)
                    break;
            }
            if(j == s.length())
                return i;
        }
        return -1;
    }
    
}