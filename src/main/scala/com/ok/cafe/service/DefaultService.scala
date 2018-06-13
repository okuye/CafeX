package com.ok.cafe.service

import com.ok.cafe.{ CafeServices, model }
import com.ok.cafe.model.MenuItem

private[cafe] class DefaultService extends CafeServices {

  override def serviceCharge(items: Seq[MenuItem]) = {
    import com.ok.cafe.util.NumberOperations._
    val sc = fullServiceCharge(items)
    if (sc > 20) 20
    else roundTodecimals(sc)
  }

  private def fullServiceCharge(items: Seq[MenuItem]): Double = {
    val standardPrice = standardBill(items)
    val modelItems = toModel(items)
    if (modelItems.forall(_.isDrink)) 0
    else if (modelItems.exists(_.isHotFood)) standardPrice * 0.2
    else standardPrice * 0.1
  }
  override def standardBill(items: Seq[MenuItem]) = {
    toModel(items).view.map(_.price).sum
  }

  private def toModel(items: Seq[MenuItem]): Seq[model.MenuItem] =
    items.map(name => MenuItem(name))

}
