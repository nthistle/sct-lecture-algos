/*
* Union-find data structure
* Loosely based on Robert Sedgewick's and Kevin Wayne's implementation
* By Sarkis Ter Martirosyan and Neil Thistlethwaite
*/

public class UnionFind<E>
{
	private E[] parent;
	private byte[] rank;
	private int count;
	

	/**
	*Instantiates an emtpy union-find data structure with n nodes, [0, n).
	*@param n the number of nodes
	*@throws IllegalArgumentException if n < 0
	**/
	public UnionFind(int n) {
		if (n < 0) throw new IllegalArgumentException();
		count = n;
		parent = new E[n];
		rank = new byte[n];
		for(int i = 0; i < n; i++) {
			parent[i] = null;
			rank[i] = 0;
		}
	}

	/**
	*Return component id for p
	*
	*@param p, a node id
	*@return component id for component w/ p
	**/
	public int find(E p) {
		assert 
	}
	public static void main(String[] args) {
		// do nothing
	}
	
}
