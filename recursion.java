import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class recursion{
  public static void main(String[] args){
    //System.out.println(sqrt(2.0,.0000001));
    //System.out.println(fib(1));
    //System.out.println(makeAllSums(3));
    System.out.println(makeAllWords(1,26));
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
    return Helper2(n,0,0,1);
  }
  private static int Helper2(int target, int current, int x, int y) {
    if (current == target){
      return x;
    }
    return Helper2(target, y, x + y, current + 1);
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
                helper (lettersLeft, a.substring(i, i + 1), words, maxLetter);
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

}
