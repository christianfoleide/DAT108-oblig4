/**
 * 
 */
package no.hvl.dat108.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.graphs.Graph;

/**
 * @author tdoy
 *
 */
class GraphTest {
	
	Graph graph;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		graph = new Graph();
		graph.addNode("1");
		graph.addNode("2");
		graph.addNode("3");
		graph.addNode("4");
		//add edges
		graph.addEdge("1", "2", 1);
		graph.addEdge("1", "3", 1);
		graph.addEdge("1", "4", 1);
		graph.addEdge("2", "3", 1);
		graph.addEdge("2", "4", 1);
		graph.addEdge("3", "4", 1);
	}

	@Test
	void test() {
		// test the adjacency list for each node/vertex
		// Node = 1
		LinkedList<String> actualadjn1 = new LinkedList<String>();
		actualadjn1.add("2");
		actualadjn1.add("3");
		actualadjn1.add("4");
		
		List<String> expectedadjn1 = graph.toString(graph.getAdjacentNodes("1"));
		
		// Node = 2
		LinkedList<String> actualadjn2 = new LinkedList<String>();
		actualadjn2.add("1");
		actualadjn2.add("3");
		actualadjn2.add("4");
		
		List<String> expectedadjn2 = graph.toString(graph.getAdjacentNodes("2"));

		// Node = 3
		LinkedList<String> actualadjn3 = new LinkedList<String>();
		actualadjn3.add("1");
		actualadjn3.add("2");
		actualadjn3.add("4");
		
		List<String> expectedadjn3 = graph.toString(graph.getAdjacentNodes("3"));
		
		// Node = 4
		LinkedList<String> actualadjn4 = new LinkedList<String>();
		actualadjn4.add("1");
		actualadjn4.add("2");
		actualadjn4.add("3");
		
		List<String> expectedadjn4 = graph.toString(graph.getAdjacentNodes("4"));
		
		assertArrayEquals(expectedadjn1.toArray(), actualadjn1.toArray());
		assertArrayEquals(expectedadjn2.toArray(), actualadjn2.toArray());
		assertArrayEquals(expectedadjn3.toArray(), actualadjn3.toArray());
		assertArrayEquals(expectedadjn4.toArray(), actualadjn4.toArray());

	}

}
