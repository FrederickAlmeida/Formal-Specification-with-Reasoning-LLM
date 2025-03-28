public class Abs {
	//@ ensures \result >= 0;
	//@ ensures (\result == num) || (\result == -num);
	public int Abs(int num) {
		if (num < 0)
			return -num;
		else
			return num;
	}
}