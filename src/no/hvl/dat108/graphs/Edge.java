/**
 * 
 */
package no.hvl.dat108.graphs;

/**
 * @author tdoy
 *
 */
public class Edge {

	private String source;
	private String destination;
	private double weight;
	private boolean visited;
	
	public Edge(String source, String destination) {
		visited = false;
		this.source = source;
		this.destination = destination;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public Edge(String source, String destination, double weight) {
		
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Edge))
			return false;
		Edge oedge = (Edge) o;
		boolean dir1 = this.source.equals(oedge.getSource()) && this.destination.equals(oedge.getDestination());
		boolean dir2 = this.source.equals(oedge.getDestination()) && this.destination.equals(oedge.getSource());
		boolean same = dir1 || dir2;
				
		return same;
	}
	
	@Override
	public final int hashCode() {
		
		int res = 1;

		res = 31 * res + ((source == null) ? 0: source.hashCode());
		res = 31 * res + ((destination == null) ? 0: destination.hashCode());
		//res = 31 * res + Double.hashCode(weight);
		
		return res;
	}
	

	@Override
	public String toString() {
		return "Source: " + source + " ,destination: " + destination;
	}

}
