package nl.codecraftr.scala.kata

import org.approvaltests.Approvals
import org.junit.jupiter.api.Test
import org.scalatestplus.junit5.JUnitSuite

class ApprovalSpec extends JUnitSuite {
  @Test
  def helloApproval(): Unit = {
    Approvals.verify("hello!")
  }
}
