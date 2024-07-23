package nl.codecraftr.scala.kata.graph.familytree

class SetsFamilyTree(persons: Set[Person], relations: Set[Relation])
    extends FamilyTree {
  override def members: Set[Person] = persons

  override def siblingsOf(person: Person): Set[Person] =
    relations
      .collect {
        case s: Sibling if s.from == person || s.to == person => s
      }
      .map(_.without(person))

  override def parentsOf(person: Person): Set[Person] = ???
  override def ancestorsOf(person: Person): Set[Person] = ???

  override def partnerOf(person: Person): Option[Person] = relations
    .collectFirst {
      case m: Marriage if m.from == person || m.to == person => m
    }
    .map(_.without(person))

  override def longestMarriage: Marriage =
    relations
      .collect { case m: Marriage => m }
      .maxBy(_.years)

  override def relationBetween(from: Person, to: Person): List[String] = ???
}
