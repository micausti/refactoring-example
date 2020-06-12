
object Movie {
  val CHILDRENS = 2
  val REGULAR = 0
  val NEW_RELEASE = 1

}
case class Movie(title: String, priceCode: Int)

case class Rental(movie: Movie, daysRented: Int)

case class Customer(name: String, rentals: List[Rental])
