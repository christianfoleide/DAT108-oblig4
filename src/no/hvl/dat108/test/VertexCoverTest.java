package no.hvl.dat108.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.graphs.Graph;
import no.hvl.dat108.graphs.VertexCover;

class VertexCoverTest {
	
	@Test
	void testApproxVC() {
		
		Graph graph1 = getGraph1();
		
		Graph graph2 = getGraph2();
		
		System.out.println("Approximate-Vertex-Cover");
		VertexCover avc = new VertexCover(graph1);
		List<String> amvc1 = avc.approxVertexCover();
		List<String> emvc1 = new ArrayList<String>(Arrays.asList("1","2","3","4"));
		
		avc = new VertexCover(graph2);
		List<String> amvc2 = avc.approxVertexCover();
		List<String> emvc2 = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f"));
		
		System.out.println(amvc1);
		System.out.println(amvc2);
		
		assertArrayEquals(emvc1.toArray(), amvc1.toArray());
		assertArrayEquals(emvc2.toArray(), amvc2.toArray());
		
		// if you do not use the code template and you implement your own graph data structure, your MVC solution
		// should be one of these:
		
		// graph1
		/*
		 * [1, 2, 4]
		 * [2, 3, 4]
		 * [1, 4, 5]
		 * [2, 3, 5]
		 * [1, 2, 3, 4]
		 * [1, 2, 3, 5]
		 * [1, 2, 4, 5]
		 * [1, 3, 4, 5]
		 * [2, 3, 4, 5]
		 * [1, 2, 3, 4, 5]
		 */
		
		// for graph2
		/*
		 * [b, d, e]
		 * [a, b, d, e]
		 * [a, c, d, e]
		 * [b, c, d, e]
		 * [a, c, d, f]
		 * [b, c, d, f]
		 * [b, d, e, f]
		 * [b, d, e, g]
		 * [a, b, c, d, e]
		 * [a, b, c, d, f]
		 * [a, b, d, e, f]
		 * [a, c, d, e, f]
		 * [b, c, d, e, f]
		 * [a, b, d, e, g]
		 * [a, c, d, e, g]
		 * [b, c, d, e, g]
		 * [a, c, d, f, g]
		 * [b, c, d, f, g]
		 * [a, c, e, f, g]
		 * [b, c, e, f, g]
		 * [b, d, e, f, g]
		 * [a, b, c, d, e, f]
		 * [a, b, c, d, e, g]
		 * [a, b, c, d, f, g]
		 * [a, b, c, e, f, g]
		 * [a, b, d, e, f, g]
		 * [a, c, d, e, f, g]
		 * [b, c, d, e, f, g]
		 * [a, b, c, d, e, f, g]
		 */

	}
	
	Graph getGraph1() {
		Graph graph1 = new Graph();
		graph1.addNode("1");
		graph1.addNode("2");
		graph1.addNode("3");
		graph1.addNode("4");
		graph1.addNode("5");
		//add edges
		graph1.addEdge("1", "2", 1);
		graph1.addEdge("1", "3", 1);
		graph1.addEdge("2", "4", 1);
		graph1.addEdge("2", "5", 1);
		graph1.addEdge("3", "4", 1);		
		graph1.addEdge("4", "5", 1);
		
		return graph1;
	}
	
	Graph getGraph2() {
		Graph graph2 = new Graph();
		graph2.addNode("a");
		graph2.addNode("b");
		graph2.addNode("c");
		graph2.addNode("d");
		graph2.addNode("e");
		graph2.addNode("f");
		graph2.addNode("g");
		
		//add edges
		graph2.addEdge("a", "b", 1);
		graph2.addEdge("b", "c", 1);
		graph2.addEdge("c", "d", 1);
		graph2.addEdge("c", "e", 1);
		graph2.addEdge("d", "e", 1);		
		graph2.addEdge("d", "f", 1);
		graph2.addEdge("d", "g", 1);
		graph2.addEdge("e", "f", 1);
		graph2.addEdge("f", "d", 1);
		
		return graph2;
	}

}
