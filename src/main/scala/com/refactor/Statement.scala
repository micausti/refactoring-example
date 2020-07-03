package com.refactor

object PrettyPrinter {

      def print(cart: Cart) = {

        println(s"Rental Record for ${cart.customer.name}\n")

        println(s"${for ((t, p) <- cart.customer.titleWithPriceCode()) println(s"Title: $t Price Code: $p\n")}\n")

        println(s"Amount owed is ${cart.calculateTotal()} \n")

        println(s"You earned ${FrequentRenterPoints(cart).calculate()} frequent renter points")
      }
  }

object ReportEndpoint {}

