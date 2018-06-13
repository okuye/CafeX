package com.ok.cafe

import com.ok.cafe.model.ItemNotSupportedException
import org.scalatest.{Matchers, WordSpec}

class CafeServicesSpec extends WordSpec with Matchers {
  private val cafeService = CafeServices()

  "standard bill" should {

    "return 3.5 for input item list: [Cole, Coffee, Cheese Sandwich]" in {
      cafeService.standardBill(Seq("Cola", "Coffee", "Cheese Sandwich")) shouldBe 3.5
    }

    "return 0 for empty input list" in {
      cafeService.standardBill(Seq()) shouldBe 0
    }

    "throw an exception on items not in found the menu" in {
      a[ItemNotSupportedException] should be thrownBy {
        cafeService.standardBill(Seq("Not existing item"))
      }
    }

  }

}
