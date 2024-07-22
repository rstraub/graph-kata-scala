package nl.codecraftr.scala.kata.graph.familytree

// How to build a graph -> https://scala-graph.org/guides/core/planning.html
case class Family() {
  def members: Set[Person] = ???

  def siblingsOf(person: Person): Set[Person] = ???
  def parentsOf(person: Person): Set[Person] = ???
  def ancestorsOf(person: Person): Set[Person] = ???

  def partnerOf(person: Person): Option[Person] = ???
  def longestMarriage: (Person, Person, Int) = ???

  def relationBetween(from: Person, to: Person): List[String] = ???
}

object Family {
  def of(persons: Set[Person], relations: Set[Relation]): Family = {
    ???
  }
}
