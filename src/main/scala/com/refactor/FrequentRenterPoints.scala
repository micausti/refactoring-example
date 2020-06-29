package com.refactor

case class FrequentRenterPoints(cart: Cart) {
  def calculate() = {
    cart.customer.rentals.map { r: Rental =>
      r.movie.priceCode match {
        case Regular => 1
        case NewRelease if r.daysRented > 1 =>  2
        case NewRelease if r.daysRented == 1 => 1
        case Childrens => 1
      }
    }.sum
  }
}
