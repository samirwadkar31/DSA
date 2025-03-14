package Graphs.TopoLogicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}}; //tricky example- here only 4 courses.
        // 0 is also there and its indegree is 0 hence initially, 0 & 3 are added to the queue with indegree 0.
        // if cycle is present topo will fail and all courses can't be finished
        System.out.println("Is it possible to finish all the courses? : " + canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // Build graph and compute in-degrees
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }

        // Initialize queue and add courses with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process courses
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // If count equals numCourses, all courses can be finished
        return count == numCourses;
    }
}
