public class Max {

  //@ requires true; // No specific preconditions
  //@ ensures \result >= i && \result >= j && \result >= k; // Result is at least as large as all inputs
  //@ ensures \result == i || \result == j || \result == k; // Result is one of the inputs
  public static int max(int i, int j, int k) {
    int t = i > j ? i : j; // t is the maximum of i and j
    return t > k ? t : k;  // Return the maximum of t and k
  }
}