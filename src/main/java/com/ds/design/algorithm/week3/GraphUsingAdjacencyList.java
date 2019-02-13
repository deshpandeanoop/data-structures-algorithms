package com.ds.design.algorithm.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphUsingAdjacencyList {
	private final boolean isDirected;
	private final Graph graph;

	public GraphUsingAdjacencyList(boolean isDirected) {
		this.isDirected = isDirected;
		this.graph = new Graph();
		this.graph.nodes = new ArrayList<>();
	}

	public void addVertex(Graph graph, int vertex, int[] edges) {
		Node newVertex = new Node(vertex);
		graph.nodes.add(newVertex);
		if (null == edges) {
			return;
		}
		Arrays.stream(edges).forEach(item -> {
			Node neighbour = new Node(item);
			newVertex.neighbours.add(neighbour);
			// Since graph is undirected, add link from destination to source
			if (isDirected) {
				graph.nodes.forEach(graphVertex -> {
					if (graphVertex.data == item) {
						graphVertex.neighbours.add(newVertex);
					}
				});
			}
		});
	}

	// Adds edges between the vertices, edges are 2X1 matrix first column, being
	// source and other is destination
	public void addEdges(Graph graph, int[][] edges) {
		if (null == edges) {
			return;
		}
		for (int i = 0; i < edges.length; i++) {
			for (Node vertex : graph.nodes) {
				if (vertex.data == edges[i][0]) {
					Node neighbour = new Node(edges[i][1]);
					vertex.neighbours.add(neighbour);
				}
				// If graph is undirected, add edge from destination to source
				if (isDirected) {
					if (vertex.data == edges[i][1]) {
						Node neighbour = new Node(edges[i][0]);
						vertex.neighbours.add(neighbour);
					}
				}
			}
		}
	}

	public Graph getGraph() {
		return this.graph;
	}

	public void printGraph(Graph graph) {
		graph.nodes.forEach(vertex -> {
			System.out.print(vertex.data + " -> ");
			vertex.neighbours.forEach(neighbour -> System.out.print(neighbour.data + " -> "));
			System.out.println();
		});
	}

	public boolean depthFirstSearch(Graph graph, int target) {
		for (Node vertex : graph.nodes) {
			if (State.UNVISITED == vertex.state && depthFirstSearchTraversal(vertex, target)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Algorithm: 1. Set the state of the vertex/node as visiting 2. Process the
	 * current vertex/node 3. Visit/Traverse the unvisited neighbours, it is
	 * really important to keep track of each vertex state to avoiding
	 * re-visiting the nodes/neighbors, eventually improves performance. 4. Set
	 * the state of the vertex/node as visited
	 */
	private boolean depthFirstSearchTraversal(Node vertex, int target) {
		// Step-1
		vertex.state = State.VISITING;
		// Step-2
		if (vertex.data == target) {
			return true;
		}
		// Step-3
		for (Node neighbour : vertex.neighbours) {
			if (neighbour.state == State.UNVISITED && depthFirstSearchTraversal(neighbour, target)) {
				return true;
			}
		}
		// Step-4
		vertex.state = State.VISITED;
		return false;
	}

	public boolean breadthFirstSearch(Graph graph, int target) {
		for (Node vertex : graph.nodes) {
			if (vertex.state == State.UNVISITED && breadthFirstSearchTraversal(vertex, target)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Algorithm: 1. Create a queue to track the neighbors 2. Set state of the
	 * vertex/Node to VISITING 3. Add vertex to the queue 4. Open a loop, which
	 * should iterate till queue becomes empty In each iteration, - Dequeue the
	 * element and say it as current - Check if the current vertex value is
	 * equals to target, if yes, return true - Add all UNVISITED neighbors to
	 * the queue - Set the status of the current vertex/node as VISITED
	 */
	private boolean breadthFirstSearchTraversal(Node vertex, int target) {
		// Step:1
		Queue<Node> queue = new LinkedList<>();
		// Step:2
		vertex.state = State.VISITING;
		// Step:3
		queue.add(vertex);
		// Step:4
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.data == target) {
				return true;
			}
			current.neighbours.forEach(neighbor -> {
				if (neighbor.state == State.UNVISITED) {
					neighbor.state = State.VISITING;
					queue.add(neighbor);
				}
			});
			current.state = State.VISITED;
		}
		return false;
	}

	public boolean depthFirstSearchWithStatus(Node head, Set<Node> set, int target) {
		set.add(head);
		if (head.data == target) {
			return true;
		}
		for (Node n : head.neighbours) {
			if (!set.contains(n) && depthFirstSearchWithStatus(n, set, target)) {
				return true;
			}
		}
		set.remove(head);
		return false;
	}

	public class Graph {
		private List<Node> nodes;

		public List<Node> getNodes() {
			return nodes;
		}

		public void setNodes(List<Node> nodes) {
			this.nodes = nodes;
		}

	}

	public boolean breadthFirstSearch(Node head, Set<Node> set, int target) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			set.add(head);
			Node x = queue.remove();
			if (x.data == target) {
				return true;
			}
			for (Node n : x.neighbours) {
				queue.add(n);
			}
			set.remove(x);
		}
		return false;
	}

	public Node clone(Node head, Set<Node> set) {
		System.out.println("Head " + head.data);
		Node clone = new Node(head.data);
		if (set.contains(head)) {
			return head;
		}
		set.add(head);
		for (Node n : head.neighbours) {
			System.out.println("Nei " + n.data);
			clone.neighbours.add(clone(n, set));
		}
		set.remove(head);
		return clone;
	}

	public Stack<Integer> topologicalSort(Node head) {
		Stack<Integer> stack = new Stack<>();
		sort(head, stack, new HashSet<>());
		return stack;
	}

	private void sort(Node head, Stack<Integer> stack, Set<Node> set) {
		set.add(head);
		for (Node neighbor : head.neighbours) {
			if (!set.contains(neighbor)) {
				topologicalSort(neighbor);
			}
		}
		set.remove(head);
		stack.add(head.data);
	}

	public class Node {
		private int data;
		private List<Node> neighbours;
		private State state;

		public Node(int data) {
			super();
			this.data = data;
			this.state = State.UNVISITED;
			this.neighbours = new ArrayList<>();
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}

	}

	private enum State {
		VISITING, UNVISITED, VISITED
	}
}
