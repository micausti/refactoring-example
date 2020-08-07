package com.refactor

sealed trait PriceCode
case object Childrens extends PriceCode
case object Regular extends PriceCode
case object NewRelease extends PriceCode

case class Movie(title: String, priceCode: PriceCode)

case class Rental(movie: Movie, daysRented: Int)

case class Customer(name: String, rentals: List[Rental]) {

  def titleWithPriceCode(): Map[String, PriceCode] = {
    (rentals.map(r => r.movie.title) zip rentals.map(r => r.movie.priceCode)).toMap
  }
}

object MoviePrices {

  //pricing
  val REGULAR_PRICE = 2.0
  val NEW_RELEASE_PRICE = 3.0
  val CHILDRENS_PRICE = 1.5

  //discounts
  val REGULAR_DISCOUNT_THRESHOLD = 2
  val REGULAR_DISCOUNT_MULTIPLIER = 1.5
  val CHILDRENS_DISCOUNT_THRESHOLD = 3
  val CHILDRENS_DISCOUNT_MULTIPLIER = 1.5

  def computePriceCode(rental: Rental): Double = {
    rental.movie.priceCode match {
      case Regular    => regularSubtotal(rental.daysRented)
      case NewRelease => newReleaseSubtotal(rental.daysRented)
      case Childrens  => childrensSubtotal(rental.daysRented)
    }
  }

  def regularSubtotal(daysRented: Int): Double = {
    if (daysRented > REGULAR_DISCOUNT_THRESHOLD)
      (daysRented - REGULAR_DISCOUNT_THRESHOLD) * REGULAR_DISCOUNT_MULTIPLIER + REGULAR_PRICE
    else REGULAR_PRICE
  }

  def newReleaseSubtotal(daysRented: Int): Double = {
    daysRented * NEW_RELEASE_PRICE
  }

  def childrensSubtotal(daysRented: Int): Double = {
    if (daysRented > CHILDRENS_DISCOUNT_THRESHOLD)
      (daysRented - CHILDRENS_DISCOUNT_THRESHOLD) * CHILDRENS_DISCOUNT_MULTIPLIER + CHILDRENS_PRICE
    else CHILDRENS_PRICE
  }
}
