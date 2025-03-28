public class NegAbs {
	
 
	//@ ensures num < 0 ==> \result == num;
	//@ ensures num >= 0 ==> \result == -num;
	public int negAbs(int num) {
		if (num < 0)
			return num;
		else
			return -num;
	}

}