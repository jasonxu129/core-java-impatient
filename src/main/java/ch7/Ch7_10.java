package ch7;

import java.util.*;

public class Ch7_10 {
    public static Map<String, Integer> dijkstrasShortedPath(String source,  Map<String, List<Neighbor>> graph) {
        Map<String, Integer> visited = new HashMap<>();

        Map<String, Neighbor> neighborMap = new HashMap<>();
        PriorityQueue<Neighbor> notVisited = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        for (String city : graph.keySet()) {
            Neighbor n = null;
            if (source.equals(city)) {
                n = new Neighbor(city, 0);
            } else {
                n = new Neighbor(city, Integer.MAX_VALUE);
            }
            neighborMap.put(city, n);
            notVisited.add(n);
        }

        while (!notVisited.isEmpty()) {
            Neighbor nextCity = notVisited.remove();
            for (Neighbor neighborCity : graph.getOrDefault(nextCity.city, Arrays.asList())) {
                if (!visited.containsKey(neighborCity.city)) {
                    Neighbor n = neighborMap.get(neighborCity.city);
                    notVisited.remove(n);
                    n.distance = Math.min(n.distance, nextCity.distance + neighborCity.distance);
                    notVisited.add(n);
                    neighborMap.put(n.city, n);
                }
            }
            visited.put(nextCity.city, nextCity.distance);
        }

        return visited;
    }

    public static class Neighbor {
        public String city;
        public int distance;
        public Neighbor(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return city + "[" + distance + "]";
        }
    }

    // Use example in https://www.youtube.com/watch?v=pVfj6mxhdMw
    //
    public static void main(String[] args) {
        Map<String, List<Neighbor>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(
                new Neighbor("B", 6),
                new Neighbor("D", 1)));
        graph.put("B", Arrays.asList(
                new Neighbor("A", 6),
                new Neighbor("D", 2),
                new Neighbor("E", 2)));
        graph.put("C", Arrays.asList(
                new Neighbor("B", 5),
                new Neighbor("E", 5)));
        graph.put("D", Arrays.asList(
                new Neighbor("A", 1),
                new Neighbor("B", 2),
                new Neighbor("E", 1)));
        graph.put("E", Arrays.asList(
                new Neighbor("B", 2),
                new Neighbor("C", 5),
                new Neighbor("D", 1)));


        Map<String, Integer> res = dijkstrasShortedPath("A", graph);
        System.out.println(res);
    }
}
