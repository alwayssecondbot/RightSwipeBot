package ru.yanes.dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBuilder {
	public static  void main(String[] args) {
		Graph  graph = new Graph();

		graph.addEdge("Moscow", "Lipetsk");
		graph.addEdge("Tula", "Lipetsk");
		graph.addEdge("Lipetsk", "Tula");
		graph.addEdge("Lipetsk", "Moscow");
		System.out.println(graph.find("Lipetsk"));
	}

	static class Graph{
		private Map<String, List<String>> adjList = new HashMap<>();

		public void addEdge(String from,String to){
			adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
		}

		private List<String> find(String label){
			return adjList.getOrDefault(label, new ArrayList<>());
		}
	}
}
