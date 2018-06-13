package com.ok.cafe.model

private[model] trait Food

private[model] trait Hot

private[model] trait Cold

private[model] trait Drink

case class ItemNotSupportedException(message: String) extends Exception(message)

private[cafe] sealed trait MenuItem {

  def price: Double

  def isDrink: Boolean = this.isInstanceOf[Drink]

  def isHotFood: Boolean = isFood && isHot

  def isFood: Boolean = this.isInstanceOf[Food]

  def isHot: Boolean = this.isInstanceOf[Hot]

}

private[cafe] object MenuItem {
  def apply(itemName: String): MenuItem = {
    itemName match {
      case "Cola" => Cola()
      case "Coffee" => Coffee()
      case "Cheese Sandwich" => CheeseSandwich()
      case "Steak Sandwich" => SteakSandwich()
      case _ =>
        throw ItemNotSupportedException(s"item not not supported: $itemName")
    }
  }
}

private[model] case class Cola(price: Double = 0.5)
  extends MenuItem
  with Drink
  with Cold

private[model] case class Coffee(price: Double = 1)
  extends MenuItem
  with Drink
  with Hot

private[model] case class CheeseSandwich(price: Double = 2)
  extends MenuItem
  with Food
  with Cold

private[model] case class SteakSandwich(price: Double = 4.5)
  extends MenuItem
  with Food
  with Hot
