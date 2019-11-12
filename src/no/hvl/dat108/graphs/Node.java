/**
 * 
 */
package no.hvl.dat108.graphs;

/**
 * @author tdoy
 *
 */
public class Node {

	private String name;
	private boolean visited;
	
	public Node(String name) {
		this.name = name;
		//visited = false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}


	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Node))
			return false;
		Node onode = (Node) o;
		boolean same = this.getName().equals(onode.getName());
		
		return same;
	}
	
	@Override
	public final int hashCode() {
		
		int res = 1;

		res = 31 * res + ((name == null) ? 0: name.hashCode());
		
		return res;
	}

}
