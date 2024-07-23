package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.immutable.Graph

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
class GraphFamilyTree(graph: Graph[Person, Relation]) extends FamilyTree {
  override def members: Set[Person] = graph.nodes.map(_.outer).toSet

  override def siblingsOf(person: Person): Set[Person] =
    graph.nodes
      .find(person)
      .map(_.outgoing)
      .getOrElse(Set.empty)
      .flatMap {
        case graph.InnerEdge(_, s: Sibling) => Some(s)
        case _                              => None
      }
      .map(_.without(person))

  override def parentsOf(person: Person): Set[Person] =
    graph
      .find(person)
      .map(_.outgoing)
      .getOrElse(Set.empty)
      .collect { case graph.InnerEdge(_, c: ChildTo) => c }
      .map(_.without(person))

  override def ancestorsOf(person: Person): Set[Person] = ???

  override def partnerOf(person: Person): Option[Person] =
    graph
      .find(person)
      .map(_.outgoing)
      .getOrElse(Set.empty)
      .collectFirst { case graph.InnerEdge(_, m: Marriage) => m }
      .map(_.without(person))

  override def longestMarriage: Marriage =
    graph.edges
      .collect { case graph.InnerEdge(_, m: Marriage) => m }
      .maxBy(_.years)

  override def relationBetween(from: Person, to: Person): List[String] = ???
}
