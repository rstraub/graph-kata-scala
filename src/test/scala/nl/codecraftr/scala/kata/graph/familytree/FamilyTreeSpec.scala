package nl.codecraftr.scala.kata.graph.familytree

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class FamilyTreeSpec
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {
  // Build an abstraction that helps us answer questions about a family, like this:
  /*
                     Joe <-> Jane
                    /           \
      Kristen <-> Greg         Sally <-> Dustin
          /    |   \                /  \
    Charles Jimmy  Mike          Mary  Jake
   */

  // 1: Build the family tree
  "family tree" should "be built" in {
    aFamily.members should have size 11
  }

  // 2: What are siblings of a person?
  "siblings" should "return siblings of a person" ignore {
    val cases = Table(
      ("person", "siblings"),
      (greg, Set(sally)),
      (sally, Set(greg)),
      (jimmy, Set(mike, charles)),
      (mary, Set(jake))
    )

    forAll(cases) { (person, siblings) =>
      aFamily.siblingsOf(person) shouldBe siblings
    }
  }

  it should "return be empty if the person has none" ignore {
    val cases = Table(
      "person",
      joe,
      jane,
      kristen,
      dustin
    )

    forAll(cases) { person =>
      aFamily.siblingsOf(person) shouldBe empty
    }
  }

  // 3: Who is partner to whom?
  "partner" should "return the partner if a person is married" ignore {
    val cases = Table(
      ("person", "partner"),
      (joe, jane),
      (kristen, greg),
      (sally, dustin)
    )

    forAll(cases) { (person, partner) =>
      aFamily.partnerOf(person) shouldBe Some(partner)
    }
  }

  // Members
  private lazy val joe = Person("Joe", 61)
  private lazy val jane = Person("Jane", 59)

  private lazy val greg = Person("Jane", 31)
  private lazy val kristen = Person("Jane", 30)
  private lazy val charles = Person("Charles", 5)
  private lazy val jimmy = Person("Jimmy", 3)
  private lazy val mike = Person("Jimmy", 1)

  private lazy val sally = Person("Sally", 30)
  private lazy val dustin = Person("Sally", 32)
  private lazy val mary = Person("Mary", 4)
  private lazy val jake = Person("jake", 3)

  private lazy val aFamily =
    Family.of(
      Set(
        joe,
        jane,
        greg,
        kristen,
        charles,
        jimmy,
        mike,
        sally,
        dustin,
        mary,
        jake
      ),
      Set(
        Sibling(greg, sally),
        Sibling(mike, jimmy),
        Sibling(mike, charles),
        Sibling(jimmy, charles),
        Sibling(mary, jake)
      )
    )
}
