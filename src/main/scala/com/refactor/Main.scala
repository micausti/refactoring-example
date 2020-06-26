package com.refactor

object Statement {
  def createStatement(customer: Customer): Unit = {
    val result: StringBuffer = new StringBuffer()
    result.append(s"Rental Record for ${customer.name}\n")

    //pricing
    val REGULAR_PRICE = 2.0
    val NEW_RELEASE_PRICE = 3.0
    val CHILDRENS_PRICE = 1.5

    //discounts
    val REGULAR_DISCOUNT_THRESHOLD = 2
    val REGULAR_DISCOUNT_MULTIPLIER = 1.5
    val CHILDRENS_DISCOUNT_THRESHOLD = 3
    val CHILDRENS_DISCOUNT_MULTIPLIER = 1.5

    customer.rentals.map(_.movie.priceCode).map { p =>
      //determine subtotal for each type
      p match {
      case Regular  => regularSubtotal(p)
      case NewRelease => newReleaseSubtotal(p)
      case Childrens => childrensSubtotal(p)
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

      def calculateFrequentRenterPoints = {
        customer.rentals.map { r: Rental =>
          //determine subtotal for each type
          r.movie.priceCode match {
            case Regular => 1
            case NewRelease if r.daysRented > 1 =>  2
            case NewRelease if r.daysRented == 1 => 1
            case Childrens => 1
          }
        }.sum
      }

      //show figures for this rental
      result.append(s"\n ${c.movie.title} \t $thisAmount \n")
      totalAmount += thisAmount
    }

    //add footer lines
    result.append(s"Amount owed is ${totalAmount} \n")
    result.append(s"You earned $frequentRenterPoints frequent renter points")

    println(result.toString)
  }
}

object Main extends App {
  Statement.createStatement(
    Customer(
      "test",
      List(
        Rental(Movie("test 1", Childrens), 2),
        Rental(Movie("test 2", Regular), 5),
        Rental(Movie("test 3", NewRelease), 1),
        Rental(Movie("test 4", Regular), 4),
        Rental(Movie("test 5", NewRelease), 3),
      )
    )
  )
}
