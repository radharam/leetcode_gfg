/**
 * Base case: If the root process is killed, all the processes will be killed
 * Build an adjacency list from the given lists.
 * Starting with kill, do a BFS for all its neighbors and iterate till you run
 * out of neighbors.
 *
 * @param pid list of processIds
 * @param ppid list of parentProcessIds of processIds, matching the order
 * @param kill id of process to be killed
 * @return list of ids of the processes that will be killed
 */

class Solution {
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0)
            return pid;

        var adjList = new HashMap<Integer, Set<Integer>>();
        for (var i = 0; i < ppid.size(); i++)
            adjList.computeIfAbsent(ppid.get(i), j -> new HashSet<>()).add(pid.get(i));

        var kills = new LinkedList<Integer>();
        var q = new LinkedList<>(List.of(kill));

        while (!q.isEmpty()) {
            kills.add(q.poll());
            q.addAll(adjList.getOrDefault(kills.peekLast(), Set.of()));
        }
        return kills;
    }
}