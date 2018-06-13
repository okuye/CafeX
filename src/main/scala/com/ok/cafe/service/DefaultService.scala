package com.ok.cafe.service

import com.ok.cafe.{CafeServices, model}
import com.ok.cafe.model.MenuItem

private[cafe] class DefaultService extends CafeServices {

  override def standardBill(items: Seq[MenuItem]) = {
    toModel(items).view.map(_.price).sum
  }

  private def toModel(items: Seq[MenuItem]): Seq[model.MenuItem] =
    items.map(name => MenuItem(name))

}
