public class LeapYearSeq {
    //@ requires year >= 0;
    //@ ensures \result <==> ((year % 4 == 0) ? ((year % 100 == 0) ? ((year % 400 == 0) ? true : false) : true) : false);
    public /*@ pure @*/ boolean isLeapYear(int year) {
        return ((year % 4 == 0) ? ((year % 100 == 0) ? ((year % 400 == 0) ? true : false) : true) : false);
   }
}

