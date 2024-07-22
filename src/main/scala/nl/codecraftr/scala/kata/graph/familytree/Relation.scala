package nl.codecraftr.scala.kata.graph.familytree

import scalax.collection.generic.AbstractUnDiEdge

sealed trait Relation

// Relation without direction
case class Sibling(sibling1: Person, sibling2: Person)
    extends AbstractUnDiEdge[Person](source = sibling1, target = sibling2)
    with Relation
