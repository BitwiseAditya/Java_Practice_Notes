
/*Course Schedule II

You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course  y first if we want to take course x.

Find the ordering of courses we should take to complete all the courses.

Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. The Driver code will print true if you return any correct order of courses else it will print false. 

Examples:

Input: n = 3, prerequisites[][] = [[1, 0], [2, 1]]
Output: true
Explanation: To take course 1, you must finish course 0. To take course 2, you must finish course 1. So the only valid order is [0, 1, 2].
Input: n = 4, prerequisites[][] = [[2, 0], [2, 1], [3, 2]]
Output: true
Explanation: Course 2 requires both 0 and 1. Course 3 requires course 2. Hence, both [0, 1, 2, 3] and [1, 0, 2, 3] are valid.
Constraints:
1 ≤ n ≤ 104
0 ≤ prerequisites.size() ≤ 105
0 ≤ prerequisites[i][0], prerequisites[i][1] < n
All prerequisite pairs are unique
prerequisites[i][0] ≠ prerequisites[i][1] */

import java.util.*;

class CourseSchedule2 {
    public ArrayList<Integer> TopologicalSorting(HashMap<Integer, ArrayList<Integer>> mp, int n) {
        int[] inorder = new int[n];
        Arrays.fill(inorder, 0);
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (Map.Entry<Integer, ArrayList<Integer>> e : mp.entrySet()) {
            ArrayList<Integer> temp = e.getValue();
            for (Integer i : temp) {
                inorder[i] += 1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inorder[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int temp = q.peek();
            q.poll();
            answer.add(temp);
            ArrayList<Integer> t = mp.getOrDefault(temp, new ArrayList<>());
            for (Integer i : t) {
                inorder[i] -= 1;
                if (inorder[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return answer;
    }

    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int e = prerequisites.length;
        for (int i = 0; i < e; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (mp.containsKey(b)) {
                mp.get(b).add(a);
            } else {
                mp.put(b, new ArrayList<>());
                mp.get(b).add(a);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(i)) {
                mp.put(i, new ArrayList<>());
            }
        }
        ArrayList<Integer> answer = TopologicalSorting(mp, n);
        if (answer.size() == n)
            return answer;
        else
            return new ArrayList<Integer>();
    }
}
