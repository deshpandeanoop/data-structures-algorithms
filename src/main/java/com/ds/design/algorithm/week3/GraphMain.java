package com.ds.design.algorithm.week3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import com.ds.design.algorithm.week3.GraphUsingAdjacencyList.Graph;
import com.ds.design.algorithm.week3.GraphUsingAdjacencyList.Node;

public class GraphMain {

	public static void main(String[] args) {
		GraphUsingAdjacencyList adjGraph = new GraphUsingAdjacencyList(false);
		Graph graph = adjGraph.getGraph();
		adjGraph.addVertex(graph, 1, null);
		adjGraph.addVertex(graph, 2, null);
		adjGraph.addVertex(graph, 3, null);
		adjGraph.addVertex(graph, 4, null);
		adjGraph.addVertex(graph, 5, null);
		int[][] edges = {{1,2},{1,3}};
		adjGraph.addEdges(graph,edges);
		edges = new int[2][2];
		edges[0][0] = 2;
		edges[0][1] = 4;
		edges[1][0] = 2;
		edges[1][1] = 5;
		adjGraph.addEdges(graph, edges);
		edges = new int[1][2];
		edges[0][0] =  3;
		edges[0][1] = 1;
		adjGraph.addEdges(graph, edges);
		//adjGraph.printGraph(graph);
	//	System.out.println(adjGraph.depthFirstSearch(graph, 3));
	//	System.out.println(adjGraph.breadthFirstSearch(graph, 3));
//		System.out.println(adjGraph.depthFirstSearchWithStatus(graph.getNodes().get(0), new HashSet<>(), 8));
//		System.out.println(adjGraph.breadthFirstSearch(graph.getNodes().get(0), new HashSet<>(), 3));
		Stack<Integer> stack = adjGraph.topologicalSort(graph.getNodes().get(0));
		stack.forEach(item->System.out.print(item+"\t"));
	}
}
