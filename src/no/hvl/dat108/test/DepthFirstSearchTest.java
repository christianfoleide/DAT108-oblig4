/**
 * 
 */
package no.hvl.dat108.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.graphs.DepthFirstSearch;
import no.hvl.dat108.graphs.Graph;

/**
 * @author tdoy
 *
 */
class DepthFirstSearchTest {
	
	@Test
	void testNonRecursive2() {
		Graph graph1 = getGraph1();
		
		Graph graph2 = getGraph2();
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph1, "1");
		Set<String> sptg1 = dfs.doDepthFirstSearch();
		
		System.out.println("DFS: "+sptg1);
		List<String> expectedG1 = new ArrayList<String>(Arrays.asList("1","2","4","3","5"));
		
		dfs = new DepthFirstSearch(graph2, "D");
		Set<String> sptg2 = dfs.doDepthFirstSearch();
		System.out.println("DFS: "+sptg2);
		
		List<String> expectedG2 = new ArrayList<String>(Arrays.asList("D","A","B","C","E","F","G"));
		
		
		assertArrayEquals(expectedG1.toArray(), sptg1.toArray());
		assertArrayEquals(expectedG2.toArray(), sptg2.toArray());
		
	}
	

	@Test
	void testNonRecursive() {
		Graph graph1 = getGraph1();
		
		Graph graph2 = getGraph2();
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph1, "1");
		Set<String> sptg1 = dfs.doDepthFirstSearch();
		
		System.out.println("DFS: "+sptg1);
		List<String> expectedG1 = new ArrayList<String>(Arrays.asList("1","3","4","5","2"));
		
		dfs = new DepthFirstSearch(graph2, "D");
		Set<String> sptg2 = dfs.doDepthFirstSearch();
		System.out.println("DFS: "+sptg2);
		
		List<String> expectedG2 = new ArrayList<String>(Arrays.asList("D","E","F","G","C","B","A"));
		
		
		assertArrayEquals(expectedG1.toArray(), sptg1.toArray());
		assertArrayEquals(expectedG2.toArray(), sptg2.toArray());
		
	}
	
	@Test
	void testRecursive() {
		Graph graph1 = getGraph1();
		
		Graph graph2 = getGraph2();
		
		DepthFirstSearch dfs = new DepthFirstSearch(graph1, "1");
		Set<String> sptg1 = dfs.doDepthFirstSearchRecursive();
		
		System.out.println("DFS: "+sptg1);
		List<String> expectedG1 = new ArrayList<String>(Arrays.asList("1","2","4","3","5"));
		
		dfs = new DepthFirstSearch(graph2, "A");
		Set<String> sptg2 = dfs.doDepthFirstSearchRecursive();
		System.out.println("DFS: "+sptg2);
		
		List<String> expectedG2 = new ArrayList<String>(Arrays.asList("A","B","C","E","D","F","G"));
		
		assertArrayEquals(expectedG1.toArray(), sptg1.toArray());
		assertArrayEquals(expectedG2.toArray(), sptg2.toArray());
	}
	
	Graph getGraph1() {
		Graph graph1 = new Graph();
		graph1.addNode("1");
		graph1.addNode("2");
		graph1.addNode("3");
		graph1.addNode("4");
		graph1.addNode("5");
		//add edges
		graph1.addEdge("1", "2", 10);
		graph1.addEdge("1", "3", 5);
		graph1.addEdge("2", "4", 4);
		graph1.addEdge("2", "5", 3);
		graph1.addEdge("3", "4", 4);		
		graph1.addEdge("4", "5", 6);
		
		return graph1;
	}
	
	Graph getGraph2() {
		Graph graph2 = new Graph();
		graph2.addNode("A");
		graph2.addNode("B");
		graph2.addNode("C");
		graph2.addNode("D");
		graph2.addNode("E");
		graph2.addNode("F");
		graph2.addNode("G");
		//add edges
		graph2.addEdge("A", "B", 1);
		graph2.addEdge("A", "D", 1);
		graph2.addEdge("A", "E", 1);
		graph2.addEdge("B", "C", 1);
		graph2.addEdge("B", "E", 1);
		graph2.addEdge("C", "E", 1);
		graph2.addEdge("C", "F", 1);
		graph2.addEdge("C", "G", 1);
		graph2.addEdge("D", "E", 1);
		graph2.addEdge("E", "F", 1);
		graph2.addEdge("F", "G", 1);
		
		return graph2;
	}

}
