package com.ok.cafe.util

import org.scalatest.{ Matchers, WordSpec }

class NumberOperationsSpec extends WordSpec with Matchers {

  "round2decimals" should {

    "rounded to 2 decimal places" in {
      NumberOperations.roundTodecimals(1.237) shouldBe 1.23
    }

  }
}
