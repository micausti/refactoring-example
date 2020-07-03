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

