object Statement {
  def createStatement(customer: Customer): Unit = {
    var totalAmount = 0.0
    var frequentRenterPoints = 0
    val result: StringBuffer = new StringBuffer()
    result.append(s"Rental Record for ${customer.name}\n")

    for (c <- customer.rentals) {
      //determine amount for each rental
      var thisAmount = 0.0
      c.movie.priceCode match {
        case Movie.REGULAR =>
          thisAmount += 2
          if (c.daysRented > 2)
            thisAmount += (c.daysRented - 2) * 1.5
        case Movie.NEW_RELEASE =>
          thisAmount += c.daysRented * 3
        case Movie.CHILDRENS =>
          thisAmount += 1.5
          if (c.daysRented > 3)
            thisAmount += (c.daysRented - 3) * 1.5
      }

      //add frequent renter points
      frequentRenterPoints += 1

      //add bonus for a two day new release rental
      if (c.movie.priceCode == Movie.NEW_RELEASE && c.daysRented > 1)
        frequentRenterPoints += 1

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
        Rental(Movie("test 1", 0), 2),
        Rental(Movie("test 2", 1), 5),
        Rental(Movie("test 3", 2), 1),
        Rental(Movie("test 4", 1), 4),
        Rental(Movie("test 5", 2), 3),
      )
    )
  )
}
