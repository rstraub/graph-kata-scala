package nl.codecraftr.scala.kata

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CanarySpec extends AnyFlatSpec with Matchers {
  "scalatest" should "run tests" in {
    Main.hello("dev") shouldEqual "Hello, creator!"
  }

}
