package nl.codecraftr.scala.kata.graph.familytree

import scala.annotation.nowarn

@nowarn
class SetsFamilyTree(persons: Set[Person], relations: Set[Relation])
    extends FamilyTree {
    override def members: Set[Person] = persons

    override def siblingsOf(person: Person): Set[Person] = ???

    override def parentsOf(person: Person): Set[Person] = ???

    override def ancestorsOf(person: Person): Set[Person] = ???

    override def partnerOf(person: Person): Option[Person] = ???

    override def longestMarriage: Marriage = ???

    override def relationBetween(from: Person, to: Person): List[String] = ???
}
