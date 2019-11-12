/**
 * 
 */
package no.hvl.dat108.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author tdoy
 *
 */

public class Graph {
	
	private Map<Node, List<Node>> adjNodes;
	private List<Edge> edges;
	
	public Graph() {
		
		adjNodes = new HashMap<Node, List<Node>>();
		edges = new ArrayList<Edge>();
	}
	
	public void addNode(String name) {
		
		Node node = new Node(name);
		adjNodes.putIfAbsent(node, new ArrayList<>());
	}
	
	public void removeNode(String name) {
		
		Node node = new Node(name);
		adjNodes.values().stream().forEach(e -> e.remove(node));
		adjNodes.remove(node);
	}
	
	public void addEdge(String name1, String name2, double weight) {
		
		Node n1 = new Node(name1);
		Node n2 = new Node(name2);
		
		adjNodes.get(n1).add(n2);
		adjNodes.get(n2).add(n1);
		
		// add edges to a list
		edges.add(new Edge(name1, name2, weight));
		
	}
	
	public void removeEdge(String name1, String name2) {
		
		Node n1 = new Node(name1);
		Node n2 = new Node(name2);
		List<Node> adjN1 = adjNodes.get(n1);
		List<Node> adjN2 = adjNodes.get(n2);
		
		if(adjN1 != null)
			adjN1.remove(n2);
		if(adjN2 != null)
			adjN2.remove(n1);
		
		edges.remove(new Edge(name1, name2));
		
	}
	
	public List<Node> getAdjacentNodes(String name){
		
		Node node = new Node(name);
		
		return adjNodes.get(node);
	}
	
	public Edge getEdge(String source, String dest) {
		
		Edge e = new Edge(source, dest);
		int index = edges.indexOf(e);
		
		return edges.get(index);
		
	}
	
	/**
	 * @return the edges
	 */
	public List<Edge> getEdges() {
		return edges;
	}
	
	public Set<Node> getNodes(){
		
		return adjNodes.keySet();
	}
	/**
	 * @return the adjNodes
	 */
	public Map<Node, List<Node>> getAdjNodes() {
		return adjNodes;
	}

	/**
	 * @param adjNodes the adjNodes to set
	 */
	public void setAdjNodes(Map<Node, List<Node>> adjNodes) {
		this.adjNodes = adjNodes;
	}
	
	
	public List<String> toString(List<Node> adjnodes) {
		
		List<String> tostring = new ArrayList<String>();
		
		for (int i=0; i<adjnodes.size(); i++) {
			tostring.add(adjnodes.get(i).getName());
		}
		
		return tostring;
	}

}
