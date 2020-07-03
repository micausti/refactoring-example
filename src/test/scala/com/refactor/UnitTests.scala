//package com.refactor
//
//import org.scalatest.flatspec.AnyFlatSpec
//import com.refactor.Cart
//
//class UnitTests extends AnyFlatSpec  {
//
//  //pricing
//  val REGULAR_PRICE = 2.0
//  val NEW_RELEASE_PRICE = 3.0
//  val CHILDRENS_PRICE = 1.5
//
//  //discounts
//  val REGULAR_DISCOUNT_THRESHOLD = 2
//  val REGULAR_DISCOUNT_MULTIPLIER = 1.5
//  val CHILDRENS_DISCOUNT_THRESHOLD = 3
//  val CHILDRENS_DISCOUNT_MULTIPLIER = 1.5
//
//  val testCart: Cart = Cart(Customer("test", List(Rental(Movie("test 1", Childrens), 2),
//    Rental(Movie("test 2", Regular), 5),
//    Rental(Movie("test 3", NewRelease), 1),
//    Rental(Movie("test 4", Regular), 4),
//    Rental(Movie("test 5", NewRelease), 3),
//  )))
//
//  val totalPrice = testCart.calculateTotal()
//  //val regularSubtotal = testCart.customer.rentals.map(_.movie.priceCode).filter(Regular)
//
//
// "Regular subtotal" should "have size ?" in {
//   regularSubtotal()
// }
//}
