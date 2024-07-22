package nl.codecraftr.scala.kata

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PropertyBasedSpec
    extends AnyFlatSpec
    with Matchers
    with ScalaCheckPropertyChecks {
  "scalacheck" should "run property-based tests" in {
    forAll { (a: Int, b: Int) =>
      a + b shouldEqual b + a
    }
  }
}
