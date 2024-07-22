package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.immutable.Graph

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
case class Family(private val graph: Graph[Person, Relation]) {
  def members: Set[Person] = graph.nodes.map(_.outer).toSet

  def siblingsOf(person: Person): Set[Person] =
    graph.nodes
      .find(person)
      .map(_.outgoing)
      .getOrElse(Set.empty)
      .flatMap {
        case graph.InnerEdge(e, _: Sibling) =>
          e.ends.filterNot(_.outer == person)
        case _ => Set.empty
      }
      .map(_.outer)

  def parentsOf(person: Person): Set[Person] = ???
  def ancestorsOf(person: Person): Set[Person] = ???

  def partnerOf(person: Person): Option[Person] =
    graph
      .find(person)
      .map(_.outgoing)
      .getOrElse(Set.empty)
      .collectFirst { case graph.InnerEdge(e, _: Marriage) => e.ends }
      .flatMap(e => e.find(_.outer != person))
      .map(_.outer)

  def longestMarriage: Marriage =
    graph.edges
      .collect { case graph.InnerEdge(_, m: Marriage) => m }
      .maxBy(_.years)

  def relationBetween(from: Person, to: Person): List[String] = ???
}

object Family {
  def of(persons: Set[Person], relations: Set[Relation]): Family =
    Family(Graph.from(persons, relations))
}
