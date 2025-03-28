public class DivisorGame {
    //@ requires n >= 1;
    //@ ensures \result <==> n % 2 == 0;
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}

