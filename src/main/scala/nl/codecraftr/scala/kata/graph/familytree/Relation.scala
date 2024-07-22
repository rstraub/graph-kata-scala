package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.generic.{AbstractDiEdge, AbstractUnDiEdge, AnyEdge}

sealed trait Relation extends AnyEdge[Person]

// Relation without direction
case class Sibling(from: Person, to: Person)
    extends AbstractUnDiEdge[Person](source = from, target = to)
    with Relation

case class Marriage(from: Person, to: Person, years: Int)
    extends AbstractUnDiEdge[Person](source = from, target = to)
    with Relation

case class ChildTo(child: Person, parent: Person)
    extends AbstractDiEdge[Person](source = child, target = parent)
    with Relation
