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
    // TODO create a new type of relation: Marriage
    // TODO add the relations to the family
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

  it should "return none if the person isn't married" ignore {
    val cases = Table(
      "person",
      charles,
      jimmy,
      mike,
      mary,
      jake
    )

    forAll(cases) { person =>
      aFamily.partnerOf(person) shouldBe None
    }
  }

  "longestMarriage" should "return who are married the longest and how long" ignore {
    // Graphs allow edges, or "relations" to have properties
    // TODO expand marriage with a "label", a property describing the years of the marriage
    // TODO add marriages to the family:
    //  Joe <-> Jane 35 years,
    //  Greg <-> Kristen 5 years,
    //  Sally <-> Dustin 8 years,

    // TODO make the test pass afterwards
    aFamily.longestMarriage shouldBe (joe, jane, 35)
  }

  "parentsOf" should "return parents of a person" ignore {
    // TODO create a new relation: Child (is it directional or undirectional?)
    // TODO add the relations to the family
    val cases = Table(
      ("person", "parents"),
      (charles, Set(greg, kristen)),
      (jimmy, Set(greg, kristen)),
      (mike, Set(greg, kristen)),
      (mary, Set(sally, dustin)),
      (jake, Set(sally, dustin)),
      (sally, Set(joe, jane)),
      (greg, Set(joe, jane))
    )

    forAll(cases) { (person, parents) =>
      aFamily.parentsOf(person) shouldBe parents
    }
  }

  it should "return nothing if parents are unknown" ignore {
    aFamily.parentsOf(joe) shouldBe Set.empty
  }

  "ancestors" should "return who came before a before a person" ignore {
    val cases = Table(
      ("person", "ancestors"),
      (charles, Set(greg, kristen, joe, jane)),
      (mary, Set(sally, dustin, joe, jane)),
      (greg, Set(joe, jane))
    )

    forAll(cases) { (person, ancestors) =>
      aFamily.ancestorsOf(person) shouldBe ancestors
    }
  }

  "relation" should "return how two persons are related" ignore {
    // TODO feel free to use actual constructs like Child/Marriage etc
    // TODO are the necessary relations in place?
    val cases = Table(
      ("persons", "relation"),
      ((joe, jane), List("marriage (jane)")),
      (
        (kristen, jane),
        List("marriage (greg)", "child (joe)", "marriage (jane)")
      ),
      (
        (mike, mary),
        List("child (greg)", "sibling (sally)", "parent (mary)")
      )
    )

    forAll(cases) { (persons, relation) =>
      aFamily.relationBetween(
        from = persons._1,
        to = persons._2
      ) shouldBe relation
    }
  }

  it should "be empty if there is no relation between two persons" ignore {
    val notRelated = Family.of(Set(jane, joe), Set.empty)

    notRelated.relationBetween(jane, joe) shouldBe empty
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
