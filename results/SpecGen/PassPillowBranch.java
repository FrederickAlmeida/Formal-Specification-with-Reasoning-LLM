class PassPillowBranch {
    //@ requires n > 1 && time >= 0;
    //@ ensures 1 <= \result && \result <= n;
    public int passPillow(int n, int time) {
        time = time % (n - 1) * 2;
        if (time < n) {
            return time + 1;
        }
        return n * 2 - time - 1;
    }
}

