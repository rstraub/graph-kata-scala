package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.immutable.Graph

trait FamilyTree {
  def members: Set[Person]

  def siblingsOf(person: Person): Set[Person]

  def parentsOf(person: Person): Set[Person]

  def ancestorsOf(person: Person): Set[Person]

  def partnerOf(person: Person): Option[Person]

  def longestMarriage: Marriage

  def relationBetween(from: Person, to: Person): List[String]
}

object FamilyTree {
  def graph(persons: Set[Person], relations: Set[Relation]): FamilyTree =
    new GraphFamilyTree(Graph.from(persons, relations))
}
