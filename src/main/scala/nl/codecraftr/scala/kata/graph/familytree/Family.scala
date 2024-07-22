package nl.codecraftr.scala.kata.graph.familytree

import scala.annotation.nowarn

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
case class Family() {
  lazy val members: Set[Person] = Set.empty

  def siblings(@nowarn person: Person): Set[Person] = Set.empty
}

object Family {
  @nowarn
  def of(persons: Set[Person], relations: Set[Relation]): Family = {
    // TODO construct the family
    Family()
  }
}
