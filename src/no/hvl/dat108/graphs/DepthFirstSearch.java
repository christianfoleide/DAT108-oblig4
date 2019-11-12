/**
 * 
 */

package no.hvl.dat108.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author tdoy
 *
 */

public class DepthFirstSearch {

	private String source;
	private Graph graph;
	
	public DepthFirstSearch(Graph graph, String source) {
		
		this.graph = graph;
		this.source = source;
	}
	
	public Set<String> doDepthFirstSearch(){
		
		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();
		
		stack.push(source);
		
		while (!stack.isEmpty()) {
			
			String node = stack.pop();
			if (!visited.contains(node)) {
				visited.add(node);
	
				for (Node node1 : graph.getAdjacentNodes(node)) {
					
					stack.push(node1.getName());
				}	
			}
		}
		
		return visited;
	}
	
	public Set<String> doDepthFirstSearchRecursive(){
		
		Set<String> visited = new LinkedHashSet<String>();
		List<Node> nodes = new ArrayList<Node>(graph.getAdjNodes().keySet());
		
		// use nodes
		Node src = nodes.get(nodes.indexOf(new Node(source)));
		dfsRecursive(nodes, src, visited);
		// call dfsRecursive method here
				
		return visited;
	}
	
	public void dfsRecursive(List<Node> nodes, Node src, Set<String> visited) {
		
		src.setVisited(true);
		visited.add(src.getName());
		
		List<Node> naboer = graph.getAdjacentNodes(src.getName());
		
		naboer.forEach( node -> {		
			
			if (!visited.contains(node.getName())) {
				
				dfsRecursive(nodes, node, visited);
			}
		});

	}
	
}
