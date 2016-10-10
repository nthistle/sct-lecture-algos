/*
* Union-find data structure
* Loosely based on Robert Sedgewick's and Kevin Wayne's implementation
* Sauce: ftp://91.193.236.10/pub/docs/linux-support/computer%20science/data%20Structures%20&%20algorithms/%5BPearson%5D%20-%20Algorithms,%204th%20ed.%20-%20%5BSedgewick,%20Wayne%5D.pdf
* By Sarkis Ter Martirosyan and Neil Thistlethwaite
* Reuse permitted with credit where credit is due
*/

public class UnionFind
{
	private int[] parent;
	private int[] size;
	private int count;
	

	/**
	*Instantiates an emtpy union-find data structure with n nodes, [0, n).
	*If data type for V parents isn't an int, use a Symbol Table (i.e. HashMap)
	*to convert to int for UF 
	*Algorithm: Weighted Quick Union
	*Constructor: O(n) | Union: O(lg n) | Find: O(lg n)
	*@param n the number of nodes
	*@throws IllegalArgumentException if n < 0
	**/
	public UnionFind(int n) {
		if (n < 0) throw new IllegalArgumentException();
		count = n;
		parent = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	/**
	*Return component parent for p
	*
	*@param p a node parent
	*@throws AssertionError if p < 0 or p >= parent.length
	*@return component parent for component w/ p
	**/
	public int find(int p) {
		assert p >= 0 && p < this.parent.length;
		while(p != this.parent[p]) p = this.parent[p];
		return p;
	}
	
	/**
	*Creates an edge between vertices v and w, merging the two nodes together
	*
	*@param v the first node
	*@param w the second node
	*@throws AssertionError if not both {@code 0 <= v < n} and {@code 0 <= w < n}
	**/
	public void union(int v, int w) {
		int i = this.find(v);
		int j = this.find(w);
		if(i == j) return;

		if (this.size[i] < this.size[j]) { 
			this.parent[i] = j;
			this.size[j] += this.size[i];
		}
		else {
			this.parent[j] = i;
			this.size[i] += this.size[j];
		}
		this.count--;
	}	
	
	/**
	*Returns the number of connected components
	*
	*@return the number of connected components
	**/
	public int count() {return this.count;}

	/**
	*Returns if two nodes are in the same component
	*
	*@param v one node
	*@param w the other node
	*@return {@code true} if {@code v} and {@code w} are connected
	*	else {@code false}
	*@throws AssertionError if not both {@code 0 <= v < n} and {@code 0 <= w < n}
	**/
	public boolean connected(int v, int w) {return this.find(v) == this.find(w);}

	public static void main(String[] args) {
		
	}
	
}
