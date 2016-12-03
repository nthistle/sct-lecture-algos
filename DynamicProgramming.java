import java.util.*;
import java.io.*;

/**
* Just a collection of algorithms/solutions to example problems
* given in the SCT lecture(s) on Dynamic Programming
* By Sarkis Ter Martirosyan and Neil Thistlethwaite<br>
**/
public class DynamicProgramming
{
   public static void main(String[] args) {
      guardMark();
   }

   public static void guardMark() {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int h = sc.nextInt();
      int[] height = new int[n];
      int[] weight = new int[n];
      int[] strength = new int[n];
      for(int i = 0; i < n; i ++) {
         height[i] = sc.nextInt();
         weight[i] = sc.nextInt();
         strength[i] = sc.nextInt();
      }
      int[] dp = new int[(1<<n)-1];
      int[] hs = new int[(1<<n)-1];
      dp[0] = Integer.MAX_VALUE;
      int prev, alt;
      for(int i = 1; i < (1<<n)-1; i ++) {
         dp[i] = -1;
         for(int j = 0; j < n; j ++) {
            if((i&(1<<j)) == 0) continue;
            prev = i-(1<<j);
            if(hs[prev]>h) continue;
            alt = strength[j];
            for(int k = 0; k < n; k ++) {
               if((prev&(1<<k)) == 0) continue;
               alt -= weight[k];
            }
            if(alt > dp[prev])
               alt = dp[prev];
            if(alt > dp[i]) {
               dp[i] = alt;
               hs[i] = hs[prev] + height[j];
            }
         }
      }
      int best = -1;
      for(int i = 0; i < (1<<n)-1; i ++) {
         if(hs[i] > h && dp[i] > best) {
            best = dp[i];
         }
      }
      if(best == -1)
         System.out.println("Mark is too tall");
      else
         System.out.println(best);
   }

}