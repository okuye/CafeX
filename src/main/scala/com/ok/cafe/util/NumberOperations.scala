package com.ok.cafe.util

object NumberOperations {
  def roundTodecimals(double: Double): Double = {
    BigDecimal(double).setScale(2, BigDecimal.RoundingMode.DOWN).toDouble
  }
}
