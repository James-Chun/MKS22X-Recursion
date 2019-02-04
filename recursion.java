import java.util.ArrayList;
import java.lang.*;

public class recursion{
  public static void main(String[] args){
    System.out.println(sqrt(2.0,.0000001));
  }
  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative
  */

  public static double sqrt(double n, double tolerance){
    return Helper1(n,1,tolerance);
  }

  private static double Helper1(double n, double guess, double tolerance){
    if ( Math.abs(n - guess*guess) > n*(tolerance/100) ){
      return Helper1(n, (n/guess + guess) / 2, tolerance);
    }
    return guess;
  }




  /*Recursively find the n'th fibbonaci number in linear time
   *fib(0) = 0; fib(1) = 1; fib(5) = 5
   *precondition: n is non-negative
   */
  public static int fib(int n){
    return Helper2(n, 0, 1, 0);
  }
  private static int Helper2(int target, int x, int y, int current) {
    if (current == target){
      return x;
    }
    return Helper2(target, y, x + y, current + 1);
  }



  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> sum = new ArrayList<Integer>();
    makeAllSumsHelper(n, 0, sum);
    return sum;
  }
  private static void makeAllSumsHelper(int max, Integer partialSum, ArrayList<Integer> sumArray) {
    if (max == 0) {
      sumArray.add(partialSum);
    }
    if (max > 0) {
      makeAllSumsHelper(max - 1, partialSum + max, sumArray);
      makeAllSumsHelper(max - 1, partialSum, sumArray);
    }
  }




}
