package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.generic.{AbstractDiEdge, AbstractUnDiEdge, AnyEdge}

sealed trait Relation extends AnyEdge[Person] {
  def from: Person
  def to: Person

  def without(person: Person): Person = Set(from, to).find(_ != person).get
}

// Relation without direction
case class Sibling(from: Person, to: Person)
    extends AbstractUnDiEdge[Person](source = from, target = to)
    with Relation

case class Marriage(from: Person, to: Person, years: Int)
    extends AbstractUnDiEdge[Person](source = from, target = to)
    with Relation

case class ChildTo(from: Person, to: Person)
    extends AbstractDiEdge[Person](source = from, target = to)
    with Relation
