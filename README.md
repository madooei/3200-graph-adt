# Graphs

The code for the graph chapter: the `Graph` ADT and `AdjacencyListGraph`, a directed graph backed by a map of maps. A JUnit suite checks the ADT's contract against the implementation.

## Prerequisites

- JDK 17+ (JUnit 6 requires it).
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      graph/
        Graph.java                    # the Graph ADT
        AdjacencyListGraph.java       # a directed graph backed by a map of maps
      map/
        Map.java                      # the course Map ADT
        HashMap.java                  # the course hash table, used for the adjacency
      demo/
        AdjacencyListGraphDemo.java
    test/
      graph/
        GraphTest.java                # the abstract Graph contract suite
        AdjacencyListGraphTest.java   # runs it against AdjacencyListGraph
  scripts/
    test.sh                           # compile and run the JUnit tests
    run.sh                            # compile and run one demo
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh graph.AdjacencyListGraphTest` — compiles everything and runs only that test class.
- `scripts/run.sh demo.AdjacencyListGraphDemo` — compiles everything and runs that one demo. Every class you implement has its own demo.

## What's here

- `graph.Graph<V>` — the ADT. Vertices behave like a set (`addVertex`, `removeVertex`, `containsVertex`). An edge is directed and carries a `double` weight; `addEdge(from, to)` uses the default weight `1.0`. `neighbors(vertex)` and `vertices()` return an `Iterable<V>`.
- `graph.AdjacencyListGraph<V>` — stores a `Map<V, Map<V, Double>>`: each vertex maps to a map from its out-neighbors to the edge weights. It also keeps a running count of edges.
- `map.Map<K, V>` and `map.HashMap<K, V>` — the course's map, reused for the outer and the inner maps.
- `graph.GraphTest` and `graph.AdjacencyListGraphTest` — the contract scenarios, run against `AdjacencyListGraph`.
- `demo.AdjacencyListGraphDemo` — builds the chapter's road map of four cities, walks the roads leaving New York, and removes Providence.
