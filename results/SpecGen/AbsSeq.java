public class AbsSeq {
    //@ ensures \result >= 0;
    //@ ensures \result == ((num < 0) ? -num : num);
    public int Abs(int num) {
        return ((num < 0) ? (-num) : (num));
    }
}
