package com.refactor

case class Cart(customer: Customer) {

  //pricing
  val REGULAR_PRICE = 2.0
  val NEW_RELEASE_PRICE = 3.0
  val CHILDRENS_PRICE = 1.5

  //discounts
  val REGULAR_DISCOUNT_THRESHOLD = 2
  val REGULAR_DISCOUNT_MULTIPLIER = 1.5
  val CHILDRENS_DISCOUNT_THRESHOLD = 3
  val CHILDRENS_DISCOUNT_MULTIPLIER = 1.5

    def calculate():Double = {
      customer.rentals.map(_.movie.priceCode).map {
        case p@Regular => regularSubtotal(p)
        case p@NewRelease => newReleaseSubtotal(p)
        case p@Childrens => childrensSubtotal(p)
      }.sum
    }

    def regularSubtotal(code: PriceCode): Double = {
      customer.rentals.map(_.daysRented).map{ d =>
        if (d > REGULAR_DISCOUNT_THRESHOLD) (d - REGULAR_DISCOUNT_THRESHOLD) * REGULAR_DISCOUNT_MULTIPLIER + REGULAR_PRICE
        else REGULAR_PRICE
      }.sum
    }

    def newReleaseSubtotal(code: PriceCode): Double = {
      customer.rentals.map(_.daysRented).map(_ * NEW_RELEASE_PRICE).sum
    }

    def childrensSubtotal(code: PriceCode): Double = {
      customer.rentals.map(_.daysRented).map{ d =>
        if (d > CHILDRENS_DISCOUNT_THRESHOLD) (d - CHILDRENS_DISCOUNT_THRESHOLD) * CHILDRENS_DISCOUNT_MULTIPLIER + CHILDRENS_PRICE
        else CHILDRENS_PRICE
      }.sum
    }
}
