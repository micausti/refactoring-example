package com.refactor

case class Cart(customer: Customer) {


  def calculateTotal(): Double = {
    customer.rentals.map(r => MoviePrices.computePriceCode(r))
    .sum
  }
}
