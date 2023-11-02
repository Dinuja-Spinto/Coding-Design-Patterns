package codingPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph with prerequisites.
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(course).add(prereq);
        }

        Stack<Integer> topologicalOrder = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, i, visited, visiting, topologicalOrder)) {
                return new ArrayList<>(); // If a cycle is detected, return an empty list.
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!topologicalOrder.isEmpty()) {
            result.add(topologicalOrder.pop());
        }

        return result;
    }

    private static boolean hasCycle(List<List<Integer>> graph, int course, boolean[] visited, boolean[] visiting, Stack<Integer> order) {
        visiting[course] = true;

        for (int neighbor : graph.get(course)) {
            if (visiting[neighbor]) {
                return true; // Cycle detected.
            } else if (!visited[neighbor] && hasCycle(graph, neighbor, visited, visiting, order)) {
                return true;
            }
        }

        visiting[course] = false;
        visited[course] = true;
        order.push(course);

        return false;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        List<Integer> result = topologicalSort(numCourses, prerequisites);

        if (result.isEmpty()) {
            System.out.println("Cycle detected. Topological sorting is not possible.");
        } else {
            System.out.println("Topological Order: " + result);
        }
    }
}
