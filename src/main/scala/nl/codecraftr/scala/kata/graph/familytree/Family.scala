package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.immutable.Graph

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
case class Family(private val graph: Graph[Person, Relation]) {
  def members: Set[Person] = graph.nodes.map(_.outer).toSet

  def siblingsOf(person: Person): Set[Person] = ???
  def parentsOf(person: Person): Set[Person] = ???
  def ancestorsOf(person: Person): Set[Person] = ???

  def partnerOf(person: Person): Option[Person] = ???
  def longestMarriage: (Person, Person, Int) = ???

  def relationBetween(from: Person, to: Person): List[String] = ???
}

object Family {
  def of(persons: Set[Person], relations: Set[Relation]): Family =
    Family(Graph.from(persons, relations))
}
