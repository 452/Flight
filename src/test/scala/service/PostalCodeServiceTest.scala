package service

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class PostalCodeServiceTest extends SpecificationWithJUnit {
  "Postal code service" should {
    "return the right number of postal codes" in new Context {
      service.postalCodes must be length 2
    }

    "return a result containing postal code 99571" in pending
  }
}

trait Context extends Scope {
  val service = new PostalCodeService("", "")
}
