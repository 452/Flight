package service

import model.PostalCode
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/22/15.
  */
class PostalCodeServiceCSVTest extends SpecificationWithJUnit {
  "Valid postal code service" should {
    "return the right number of postal codes" in new Context {
      val bla = service.validPostalCodes
      service.validPostalCodes must be length 2

    }

    "return the expected result" in new Context {
      val expected = Seq(
        PostalCode(Some("US"),"34034",Some("APO"),None,Some("AA"),Some("Dillon"),Some("033"),None,None,Some(33.0364),Some(-82.2493),None),
        PostalCode(Some("US"),"99553",Some("Akutan"),Some("Alaska"),Some("AK"),Some("Aleutians East"),Some("013"),None,None,Some(54.143),Some(-165.7854),None)
      )
      service.validPostalCodes must be equalTo expected
    }
  }
}

trait Context extends Scope {
  val postalCodesMetaDataFile = "src/test/resources/PostalCodes.txt"
  val validPostalCodesFile = "src/test/resources/ValidPostalCodes.txt"
  val service = new PostalCodeServiceCSV(postalCodesMetaDataFile, validPostalCodesFile)
}
