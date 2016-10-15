import java.util.*;
import java.io.*;

/**
* Minimum Spanning Tree data structure<br>
* By Sarkis Ter Martirosyan and Neil Thistlethwaite<br>
* Reuse permitted with credit where credit is due
**/

public class MinimumSpanningTree
{
   private int[][] edges;
   private double[] weights;
   private int count;
   private int curEdge;
   private UnionFind uf;
   
   /**
   *Instantiates an emtpy minimum spanning tree data structure with n nodes and e edges
   *Algorithm: Kruskal's Algorithm
   *@param n the number of nodes
   *@param e the number of edges
   *@throws IllegalArgumentException if n < 0 or e < 0
   **/
   public MinimumSpanningTree(int n, int e) {
      uf = new UnionFind(n);
      count = n;
      edges = new int[e][2];
      weights = new double[e];
      for(int i = 0; i < e; i++) {
         edges[i][0] = edges[i][1] = -1;
         weights[i] = -1;
      }
      curEdge = 0;
   }
   
   
   
   public void addEdge(int a, int b, int w) {
      if(a < 0 || a >= this.count || b < 0 || b >= this.count || this.curEdge >= this.count)
          throw new IndexOutOfBoundsException();
      if(a == b) throw new IllegalArgumentException();
      edges[this.curEdge][0] = a;
      edges[this.curEdge++][1] = b;
      uf.union(a, b);
   }
   

   /**
   *Demonstration of the abilities of this implementation
   *
   *@param args the terminal arguments, the first of which is input file
   *@throws IOException if the specified file doesn't exist
   **/
   public static void main(String[] args) throws IOException {
      //args[0] = name of text file to read
      Scanner fin = new Scanner(new File(args[0]));
      int n = fin.nextInt(); // num nodes
      int e = fin.nextInt(); // num edges
      MinimumSpanningTree mst = new MinimumSpanningTree(n, e);
   }         

}