package com.refactor

object Statement {
  def createStatement(customer: Customer): Unit = {
    val result: StringBuffer = new StringBuffer()
    result.append(s"Rental Record for ${customer.name}\n")








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
