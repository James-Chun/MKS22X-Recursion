import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class recursion{
  /*Recursively find the sqrt using Newton's approximation
   *tolerance is the allowed percent error the squared answer is away from n.
   *precondition: n is non-negative
  */

  public double sqrt(double n, double tolerance){
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
  public int fib(int n){
    return Helper2(n,0,0,1);
  }
  private static int Helper2(int target, int current, int x, int y) {
    if (current == target){
      return x;
    }
    return Helper2(target, current + 1, y, x + y);
  }


  /*As Per classwork*/
    public static ArrayList<Integer> makeAllSums(int n) {
      ArrayList<Integer> sum = new ArrayList<Integer>();
      Helper3(sum, n, 0);
      return sum;
    }
    private static void Helper3(ArrayList<Integer> sum, int max, Integer partialSum) {

      if (max == 0) {
        sum.add(partialSum);
      }


      else if (max > 0) {
        Helper3(sum, partialSum + max, max - 1);
        Helper3(sum, partialSum, max - 1);
      }
    }


    //February 4, 2018
    public static List<String> makeAllWords(int lettersLeft, int maxLetter){
        List<String> words = new ArrayList<String>();
        String a = "abcdefghijklmnopqrstuvwxyz";
        if (lettersLeft > 0){
          for (int i = 0; i < maxLetter; i ++){
                helper (lettersLeft-1, a.substring(i, i + 1), words, maxLetter);
          }
        }
        return words;
    }


    public static void helper (int lettersLeft, String ans, List<String> words, int maxLetter){
        String b = "abcdefghijklmnopqrstuvwxyz";
        if (lettersLeft > 0){
            for (int i = 0; i < maxLetter; i ++){
                helper (lettersLeft - 1, ans+ b.substring(i, i + 1), words, maxLetter);;
            }
        }
        else words.add(ans);
    }


    //--------------------------------------------------------------------------------------------------------------------------------------------------------------
    //TESTING

    public static boolean closeEnough(double a, double b){
        if(a==0.0 && b==0.0)return true;
        if(a==0.0)return b < 0.00000000001;
        if(b==0.0)return a < 0.00000000001;
        return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

    }


    //testcase must be a valid index of your input/output array
    public static void testFib(int testcase){
      recursion r = new recursion();
      int[] input = {0,1,2,3,5,30};
      int[] output ={0,1,1,2,5,832040};
      int max = input.length;
      if(testcase < input.length){
        int in = input[testcase];
        try{

          int ans = r.fib(in);
          int correct = output[testcase];
          if(ans == correct){
            System.out.println("PASS test fib "+in+". "+correct);
          }
          else{
            System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test fib"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }


    //testcase must be a valid index of your input/output array
    public static void testSqrt(int testcase){
      recursion r = new recursion();
      double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
      double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
      int max = input.length;
      if(testcase < input.length){
        double in = input[testcase];
        try{

          double ans = r.sqrt(in,.00001);
          double correct = Math.sqrt(in);
          if(closeEnough(ans,correct)){
            System.out.println("PASS test sqrt "+in+" "+ans);
          }
          else{
            System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

          }
        }catch(IllegalArgumentException n){
          if(in < 0){
            System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
          }else{
            System.out.println(" FAIL IllegalArgumentException in test case:"+in);
          }
        }catch(Exception e){
          System.out.println(" FAIL Some exception in test case:"+in);
        }
      }
    }




    public static void main(String args[]){
      //System.out.println(sqrt(2.0,.0000001));
      //System.out.println(fib(1));
      //System.out.println(makeAllSums(3));
      //System.out.println(makeAllWords(2,3));
      testFib(0);
      testFib(1);
      testFib(2);
      testFib(3);
      testFib(4);
      testFib(5);

      testSqrt(0);
      testSqrt(1);
      testSqrt(2);
      testSqrt(3);
      testSqrt(4);
    }

}
