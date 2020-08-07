package com.refactor

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UnitTests extends AnyWordSpec with Matchers {

  val testCart: Cart = Cart(Customer("test",
    List(Rental(Movie("test 1", Childrens), 2),
        Rental(Movie("test 2", Regular), 5),
        Rental(Movie("test 3", NewRelease), 1),
        Rental(Movie("test 4", Regular), 4),
        Rental(Movie("test 5", NewRelease), 3)
  )))

  "Cart" should {
    "calculate cart total" in {
      testCart.calculateTotal() shouldBe 25
    }

  }
}
