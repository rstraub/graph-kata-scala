package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.generic.{AbstractUnDiEdge, AnyEdge}

sealed trait Relation extends AnyEdge[Person] {
  def from: Person
  def to: Person
}

// Relation without direction
case class Sibling(from: Person, to: Person)
    extends AbstractUnDiEdge[Person](source = from, target = to)
    with Relation
