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

  override def partnerOf(person: Person): Option[Person] = ???

  override def longestMarriage: Marriage = ???

  override def relationBetween(from: Person, to: Person): List[String] = ???
}
