package parsers

import java.text.ParseException

import model.PostalCode
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
  * Created by ogur on 12/23/15.
  */
class PostalCodeParserCSVTest extends SpecificationWithJUnit {

  "Parse" should {
    "return a result with the correct length" in new PostalCodeParserCSVTestContext {
      postalCodeParserCSV.parse must be length 3
    }

    "return the expected result" in new PostalCodeParserCSVTestContext {

      val expected = List(PostalCode(Some("US"),"34050",Some("FPO"),None,Some("AA"),
                              Some("Erie"),Some("029"),None,None,Some(41.0375),Some(-111.6789),None),
                          PostalCode(Some("US"),"34034",Some("APO"),None,Some("AA"),
                            Some("Dillon"),Some("033"),None,None,Some(33.0364),Some(-82.2493),None),
                          PostalCode(Some("US"),"99553",Some("Akutan"),Some("Alaska"),Some("AK"),
                            Some("Aleutians East"),Some("013"),None,None,Some(54.143),Some(-165.7854),None))

      postalCodeParserCSV.parse must be equalTo expected
    }

    "throw an exception" in new PostalCodeParserCSVTestContext {
      val badFilePath = "src/test/resources/InvalidFormatPostalCodes.txt"
      override val postalCodeParserCSV = new PostalCodeParserCSV(badFilePath)
      postalCodeParserCSV.parse must throwA[ParseException]
    }
  }
}

trait PostalCodeParserCSVTestContext extends Scope {
  val filePath = "src/test/resources/PostalCodes.txt"
  val postalCodeParserCSV = new PostalCodeParserCSV(filePath)
}