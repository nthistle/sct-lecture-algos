import java.util.*;
import java.io.*;

/**
* Minimum Spanning Tree data structure<br>
* By Sarkis Ter Martirosyan and Neil Thistlethwaite<br>
**/

public class MinimumSpanningTree
{
   private Edge[] edges;
   private int count;
   private int ecount;
   private int curEdge;
   
   /**
   *Instantiates an emtpy minimum spanning tree data structure with n nodes and e edges
   *Algorithm: Kruskal's Algorithm
   *@param n the number of nodes
   *@param e the number of edges
   *@throws IllegalArgumentException if n < 0 or e < 0
   **/
   public MinimumSpanningTree(int n, int e) {
      count = n;
      ecount = e;
      edges = new Edge[e];
      curEdge = 0;
   }
   
   
   public void addEdge(int a, int b, double w) {
      if(a < 0 || a >= ecount || b < 0 || b >= ecount || curEdge >= ecount)
          throw new IndexOutOfBoundsException();
      if(a == b) throw new IllegalArgumentException();
      edges[curEdge++] = new Edge(a, b, w);
   }
   
   public int[][] getMST() {
      int i = 0;
      Arrays.sort(edges);
      UnionFind uf = new UnionFind(count);
      int[][] mst = new int[count-1][2];
      for(int j = 0; j < ecount; j++) {
         if(!uf.connected(edges[j].a, edges[j].b)) {
            uf.union(edges[j].a, edges[j].b);
            mst[i][0] = edges[j].a;
            mst[i++][1] = edges[j].b;
         }
      }
      return mst;
   }
   
   /**
   * used to make sorting the edges by weight easier using
   * Java's native sorting functions
   **/
   class Edge implements Comparable<Edge>
   {
      public double weight;
      public int a;
      public int b;
      
      public Edge(int a, int b, double weight) {
         this.a = a;
         this.b = b;
         this.weight = weight;
      }
     
      
      public int compareTo(Edge e) {
         if(weight > e.weight)
            return 1;
         else if(weight < e.weight)
            return -1;
         return 0;
      }
      
      public boolean equals(Object obj) {
         if(obj instanceof Edge)
            return compareTo((Edge)obj) == 0;
         return false;
      }
      
      public String toString() {
         return "[" + a + "<->" + b + ",w=" + weight + "]";
      }
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
      // now read in e edges
      for(int i = 0; i < e; i++) {
         mst.addEdge(fin.nextInt(), fin.nextInt(), fin.nextDouble());
      }
      // now find MST
      int[][] answer = mst.getMST();
      System.out.println("MST represented by edges: ");
      for(int i = 0; i < n-1; i ++) {
         System.out.println("(" + answer[i][0] + "," + answer[i][1] + ")");
      }
   }

}