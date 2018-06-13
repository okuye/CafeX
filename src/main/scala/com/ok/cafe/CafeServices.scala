package com.ok.cafe

import com.ok.cafe.model.ItemNotSupportedException
import com.ok.cafe.service.DefaultService

trait CafeServices {
  type MenuItem = String
  type Price = Double

  @throws[ItemNotSupportedException]("One or more MenuItems are not supported")
  def standardBill(items: Seq[MenuItem]): Price

}

object CafeServices {
  def apply(): CafeServices = new DefaultService
}
