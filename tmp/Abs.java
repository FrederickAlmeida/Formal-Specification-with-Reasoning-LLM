public class Abs {
	
	//@ ensures \result == (num < 0 ? -num : num);
	//@ ensures \result >= 0;
	public int Abs(int num) {
		if (num < 0)
			return -num;
		else
			return num;
	}
}