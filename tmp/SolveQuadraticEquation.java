import java.lang.Math;

public class SolveQuadraticEquation {
    /*@ requires a != 0; // a must not be zero for a valid quadratic equation
      @ ensures \result.length == 2; // the result array has exactly two elements
      @ ensures (b*b - 4*a*c > 0) ==> (\result[0] == (-b - Math.sqrt(b*b - 4*a*c)) / (2*a) && \result[1] == 0);  
      @ ensures (b*b - 4*a*c < 0) ==> (\result[0] == -b / (2*a) && \result[1] == Math.sqrt(- (b*b - 4*a*c)) / (2*a));
      @*/
    public static double[] solve(int a, int b, int c) {
        double[] res = new double[2];
        double delta = b * b - 4 * a * c;

        if(delta >= 0) {
            res[0] = (-b - Math.sqrt(delta)) / (2 * a);
            res[1] = 0;
        }
        else {
            res[0] = -b / (2*a);
            res[1] = Math.sqrt(-delta) / (2*a);
        }
        return res;
    } 
}
