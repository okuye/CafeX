package com.ok.cafe

import com.ok.cafe.model.ItemNotSupportedException
import org.scalatest.{ Matchers, WordSpec }

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

  "service charge" should {

    "apply no service charge, when all purchased items are drinks" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola")) shouldBe 0
    }

    "apply a service charge of 10% to the total bill, when purchased items include any food" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola", "Cheese Sandwich")) shouldBe 0.35
    }

    "apply a service charge of 20%, when purchased items include any hot food" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola", "Steak Sandwich")) shouldBe 1.2
    }

    "apply a service charge of 20%, when purchased items include any hot food and any cold food" in {
      cafeService.serviceCharge(
        Seq("Coffee", "Cola", "Steak Sandwich", "Cheese Sandwich")
      ) shouldBe 1.6
    }

    "apply a service charge of maximum 20 pounds " in {
      cafeService.serviceCharge((1 to 30).map(_ => "Steak Sandwich")) shouldBe 20
    }

  }

}
