package com.refactor

sealed trait PriceCode
case object Childrens extends PriceCode
case object Regular extends PriceCode
case object NewRelease extends PriceCode

case class Movie(title: String, priceCode: PriceCode)

case class Rental(movie: Movie, daysRented: Int)

case class Customer(name: String, rentals: List[Rental])
