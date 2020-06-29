package com.refactor

sealed trait Statement {
  def cartTotal(customer:Customer) = Cart.apply(customer).calculate()
  def frequentRenterPoints(customer: Customer) = FrequentRenterPoints.apply(customer).calculate()
}

case object PrettyPrinter extends Statement {

  def getPrices(cart: Cart): List[Unit] = {
    cart.customer.rentals.map { r: Rental =>
      r.movie.priceCode match {
        case Regular => println(s"\n ${cart.customer.rentals.map(_.movie.title)} \t ${cart.customer.rentals.map(_.movie.priceCode)} \t ${cart.REGULAR_PRICE}")
        case NewRelease => println(s"\n ${cart.customer.rentals.map(_.movie.title)} \t ${cart.customer.rentals.map(_.movie.priceCode)} \t ${cart.NEW_RELEASE_PRICE}")
        case Childrens => println(s"\n ${cart.customer.rentals.map(_.movie.title)} \t ${cart.customer.rentals.map(_.movie.priceCode)} \t ${cart.CHILDRENS_PRICE}")
      }
    }
  }

      def print(cart: Cart) = {

        val result: StringBuffer = new StringBuffer()

        result.append(s"Rental Record for ${cart.customer.name}\n")

        //show figures for this rental
        result.append(s"${getPrices(cart)}")

        //add footer lines
        result.append(s"Amount owed is ${cart.calculate()} \n")
        result.append(s"You earned ${FrequentRenterPoints.apply(cart).calculate()} frequent renter points")

        println(result.toString)
      }
  }


case object ReportEndpoint extends Statement

