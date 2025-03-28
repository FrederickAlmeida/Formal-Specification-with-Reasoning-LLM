class PassPillow {
    //@ requires n > 0 && time >= 0;
    //@ ensures \result >= 1 && \result <= n;
    public int passPillow(int n, int time) {
        //@ assume n != 1;
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }
}

