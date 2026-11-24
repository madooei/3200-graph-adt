package demo;

import graph.AdjacencyListGraph;
import graph.Graph;

/** A demo of AdjacencyListGraph on the chapter's road map of four cities. */
public final class AdjacencyListGraphDemo {

  private AdjacencyListGraphDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Graph<String> roads = new AdjacencyListGraph<>();
    roads.addVertex("Albany");
    roads.addVertex("Boston");
    roads.addVertex("New York");
    roads.addVertex("Providence");
    addRoad(roads, "Albany", "Boston", 170.0);
    addRoad(roads, "Albany", "New York", 150.0);
    addRoad(roads, "Boston", "Providence", 50.0);
    addRoad(roads, "New York", "Providence", 180.0);

    // Expect 4 vertices and 8 edges, two per road.
    System.out.println("vertices: " + roads.numVertices());
    System.out.println("edges: " + roads.numEdges());

    // Expect Albany 150.0 and Providence 180.0.
    System.out.println("roads leaving New York:");
    for (String neighbor : roads.neighbors("New York")) {
      double miles = roads.weight("New York", neighbor);
      System.out.println("  " + neighbor + " " + miles);
    }

    // Expect true: the road from Boston to Albany was added in both directions.
    System.out.println("Boston -> Albany: " + roads.containsEdge("Boston", "Albany"));

    // Expect true, then 3 vertices and 4 edges: the two roads to Providence are gone.
    System.out.println("remove Providence: " + roads.removeVertex("Providence"));
    System.out.println("vertices: " + roads.numVertices());
    System.out.println("edges: " + roads.numEdges());
  }

  // Adds a two-way road as one directed edge in each direction.
  private static void addRoad(Graph<String> roads, String city, String other, double miles) {
    roads.addEdge(city, other, miles);
    roads.addEdge(other, city, miles);
  }
}
