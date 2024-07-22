package nl.codecraftr.scala.kata.graph.familytree

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
case class Family() {
  def members: Set[Person] = ???

  def siblingsOf(person: Person): Set[Person] = ???

  def partnerOf(person: Person): Option[Person] = ???
}

object Family {
  def of(persons: Set[Person], relations: Set[Relation]): Family = {
    ???
  }
}
