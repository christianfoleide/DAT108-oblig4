/**
 * 
 */
package no.hvl.dat108.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tdoy
 *
 */
public class VertexCover {

	/**
	 * 
	 */

	private Graph graph;
	
	public VertexCover(Graph graph) {
		
		this.graph = graph;
		
	}
	
	public List<String> approxVertexCover() {
		
		List<String> approxmvc = new ArrayList<String>(); 						
		
		Queue<Edge> queue = new LinkedList<Edge>(graph.getEdges());
		
		Queue<Edge> copy = new LinkedList<Edge>(graph.getEdges());
		
		while (!queue.isEmpty()) {
			
			Edge e = queue.peek();
			String eSource = e.getSource();
			String eDest = e.getDestination();
	
			approxmvc.add(eSource);
			approxmvc.add(eDest);
			
			
			for(Edge e2 : copy) {
			
				String e2Source = e2.getSource();
				String e2Dest = e2.getDestination();
				
				if (approxmvc.contains(e2Source) || approxmvc.contains(e2Dest)) {
					queue.remove();
					
				} else {
					queue.remove();
					approxmvc.add(eSource);
					approxmvc.add(eDest);
				}
				
				if (queue.size() == 0) {
					break;
				}
								
				e = queue.peek();
				eSource = e.getSource();
				eDest = e.getDestination();
	
			}
		} 
		
		return approxmvc;		
	}
	
}
