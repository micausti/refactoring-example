package com.refactor

sealed trait Statement {
  def cartTotal(customer:Customer) = Cart.apply(customer).calculate()
  def frequentRenterPoints(cart: Cart) = FrequentRenterPoints.apply(cart).calculate()
}

case object PrettyPrinter extends Statement {

  def titleToPriceMap(cart:Cart) = {
    for ((k, v) <-(printTitles(cart) zip printPrices(cart)).toMap) printf("Title: %s, Type: %s\n", k, v)
  }

  def printTitles(cart:Cart): List[String] = {
    cart.customer.rentals.map(r=> r.movie.title)
  }

  def printPrices(cart:Cart): List[PriceCode] = {
    cart.customer.rentals.map(r=> r.movie.priceCode)
  }

      def print(cart: Cart) = {

        val result: StringBuffer = new StringBuffer()

        result.append(s"Rental Record for ${cart.customer.name}\n")

        //result.append(s"Movie Title: ${printTitles(cart)}  Movie Type: ${printPrices(cart)} \n")
        result.append(s"${titleToPriceMap(cart)}")

        //add footer lines
        result.append(s"Amount owed is ${cart.calculate()} \n")
        result.append(s"You earned ${FrequentRenterPoints.apply(cart).calculate()} frequent renter points")

        println(result.toString)
      }
  }


case object ReportEndpoint extends Statement

