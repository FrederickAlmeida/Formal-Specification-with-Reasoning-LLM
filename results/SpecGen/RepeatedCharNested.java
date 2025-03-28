public class RepeatedCharNested {

 
    //@ ensures 0 < \result && \result < s.length() ==> (\exists int j; \result + 1 < j && j < s.length(); s.charAt(\result) == s.charAt(j)) || (\forall int k; \result + 1 < k && k < s.length(); s.charAt(\result) != s.charAt(k));  
    public static int repeatedChar(String s) {
        //@ maintaining 0 <= i && i <= s.length();
        //@ maintaining (\forall int x; 0 <= x && x < i; (\forall int y; i + 1 <= y && y < s.length(); s.charAt(x) != s.charAt(y)));
        //@ decreases s.length() - i;
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            //@ maintaining i + 1 <= j && j <= s.length();
            //@ maintaining (\exists int y; i + 1 - 1 <= y && y < j; s.charAt(i) == s.charAt(y)) && (\forall int k; i + 1 < k && k < j; s.charAt(i) != s.charAt(k));  
            //@ decreases s.length() - j;
            for (int j = i + 1; j < s.length(); ++j) {
                char c2 = s.charAt(j);
                if(c1 == c2)
                    return i;
            }
        }
        return -1;
    }
    
}